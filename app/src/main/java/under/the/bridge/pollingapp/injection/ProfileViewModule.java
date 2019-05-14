package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import under.the.bridge.pollingapp.interactor.ProfileInteractor;
import under.the.bridge.pollingapp.interactor.impl.ProfileInteractorImpl;
import under.the.bridge.pollingapp.presenter.ProfilePresenter;
import under.the.bridge.pollingapp.presenter.impl.ProfilePresenterImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;

@Module
public final class ProfileViewModule {
    @Provides
    public ProfileInteractor provideInteractor() {
        return new ProfileInteractorImpl();
    }

    @Provides
    public PresenterFactory<ProfilePresenter> providePresenterFactory(@NonNull final ProfileInteractor interactor) {
        return new PresenterFactory<ProfilePresenter>() {
            @NonNull
            @Override
            public ProfilePresenter create() {
                return new ProfilePresenterImpl(interactor);
            }
        };
    }
}
