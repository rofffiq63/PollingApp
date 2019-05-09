package under.the.bridge.pollingapp;

import android.app.Application;
import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.AppModule;
import under.the.bridge.pollingapp.injection.DaggerAppComponent;

public final class PollApp extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}