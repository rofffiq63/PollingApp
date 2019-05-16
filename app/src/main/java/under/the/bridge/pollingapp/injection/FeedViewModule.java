package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.interactor.FeedInteractor;
import under.the.bridge.pollingapp.interactor.impl.FeedInteractorImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.FeedPresenter;
import under.the.bridge.pollingapp.presenter.impl.FeedPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class FeedViewModule {
    @Provides
    public FeedInteractor provideInteractor() {
        return new FeedInteractorImpl();
    }

    @Provides
    public PresenterFactory<FeedPresenter> providePresenterFactory(@NonNull final FeedInteractor interactor) {
        return new PresenterFactory<FeedPresenter>() {
            @NonNull
            @Override
            public FeedPresenter create() {
                return new FeedPresenterImpl(interactor);
            }
        };
    }
}
