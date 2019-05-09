package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.interactor.SplashInteractor;
import under.the.bridge.pollingapp.interactor.impl.SplashInteractorImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.SplashPresenter;
import under.the.bridge.pollingapp.presenter.impl.SplashPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class SplashViewModule {
    @Provides
    public SplashInteractor provideInteractor() {
        return new SplashInteractorImpl();
    }

    @Provides
    public PresenterFactory<SplashPresenter> providePresenterFactory(@NonNull final SplashInteractor interactor) {
        return new PresenterFactory<SplashPresenter>() {
            @NonNull
            @Override
            public SplashPresenter create() {
                return new SplashPresenterImpl(interactor);
            }
        };
    }
}
