package under.the.bridge.pollingapp.utils;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;
import under.the.bridge.pollingapp.model.PollLoginResponse;

/**
 * Created by ennur on 6/25/16.
 */
public interface EndPointService {

    @POST("login")
    @FormUrlEncoded
    Observable<PollLoginResponse> loginPoll(@Field("google_id") String gId, @Field("name") String nm, @Field("email") String eml);

}
