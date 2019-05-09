package under.the.bridge.pollingapp.injection;

import android.content.Context;

import under.the.bridge.pollingapp.PollApp;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getAppContext();

    PollApp getApp();
}