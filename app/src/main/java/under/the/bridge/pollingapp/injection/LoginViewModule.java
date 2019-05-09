package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.interactor.LoginInteractor;
import under.the.bridge.pollingapp.interactor.impl.LoginInteractorImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.LoginPresenter;
import under.the.bridge.pollingapp.presenter.impl.LoginPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class LoginViewModule {
    @Provides
    public LoginInteractor provideInteractor() {
        return new LoginInteractorImpl();
    }

    @Provides
    public PresenterFactory<LoginPresenter> providePresenterFactory(@NonNull final LoginInteractor interactor) {
        return new PresenterFactory<LoginPresenter>() {
            @NonNull
            @Override
            public LoginPresenter create() {
                return new LoginPresenterImpl(interactor);
            }
        };
    }
}
