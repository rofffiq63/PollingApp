package under.the.bridge.pollingapp.injection;

import under.the.bridge.pollingapp.view.impl.SplashActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = SplashViewModule.class)
public interface SplashViewComponent {
    void inject(SplashActivity activity);
}