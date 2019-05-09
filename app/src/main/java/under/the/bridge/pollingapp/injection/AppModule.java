package under.the.bridge.pollingapp.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.PollApp;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {
    @NonNull
    private final PollApp mApp;

    public AppModule(@NonNull PollApp app) {
        mApp = app;
    }

    @Provides
    public Context provideAppContext() {
        return mApp;
    }

    @Provides
    public PollApp provideApp() {
        return mApp;
    }
}
