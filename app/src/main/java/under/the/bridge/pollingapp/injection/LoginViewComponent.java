package under.the.bridge.pollingapp.injection;

import under.the.bridge.pollingapp.view.impl.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginViewModule.class)
public interface LoginViewComponent {
    void inject(LoginActivity activity);
}