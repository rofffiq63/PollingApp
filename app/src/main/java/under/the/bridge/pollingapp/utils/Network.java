package under.the.bridge.pollingapp.utils;

import android.app.Activity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import under.the.bridge.pollingapp.BuildConfig;

/**
 * Created by Khadafi on 10/01/2018.
 */

public class Network {
    public static EndPointBridgeService builder(File cacheFile, final Activity context) {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
        final SessionManager sessionManager = new SessionManager(context);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {

                        Request original = chain.request();

                        // Customize the request
                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .header("X-Authorization", sessionManager.getTokenUser())
                                .removeHeader("Pragma")
                                .header("Cache-Control", String.format("max-age=%d", BuildConfig.CACHETIME))
                                .url(original.url())
                                .build();

                        okhttp3.Response response = chain.proceed(request);
                        response.cacheResponse();
                        // Customize or return the response
                        return response;
                    }
                })

                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(getGsonViaBuilder()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return new EndPointBridgeService(retrofit.create(EndPointService.class));
    }

    private static Gson getGsonViaBuilder() {
        return new GsonBuilder().serializeNulls().create();
    }
}
