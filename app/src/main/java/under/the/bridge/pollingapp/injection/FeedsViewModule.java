package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.interactor.FeedsInteractor;
import under.the.bridge.pollingapp.interactor.impl.FeedsInteractorImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.FeedsPresenter;
import under.the.bridge.pollingapp.presenter.impl.FeedsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class FeedsViewModule {
    @Provides
    public FeedsInteractor provideInteractor() {
        return new FeedsInteractorImpl();
    }

    @Provides
    public PresenterFactory<FeedsPresenter> providePresenterFactory(@NonNull final FeedsInteractor interactor) {
        return new PresenterFactory<FeedsPresenter>() {
            @NonNull
            @Override
            public FeedsPresenter create() {
                return new FeedsPresenterImpl(interactor);
            }
        };
    }
}
