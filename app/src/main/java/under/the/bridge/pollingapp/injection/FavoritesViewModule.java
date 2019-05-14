package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import under.the.bridge.pollingapp.interactor.FavoritesInteractor;
import under.the.bridge.pollingapp.interactor.impl.FavoritesInteractorImpl;
import under.the.bridge.pollingapp.presenter.FavoritesPresenter;
import under.the.bridge.pollingapp.presenter.impl.FavoritesPresenterImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;

@Module
public final class FavoritesViewModule {
    @Provides
    public FavoritesInteractor provideInteractor() {
        return new FavoritesInteractorImpl();
    }

    @Provides
    public PresenterFactory<FavoritesPresenter> providePresenterFactory(@NonNull final FavoritesInteractor interactor) {
        return new PresenterFactory<FavoritesPresenter>() {
            @NonNull
            @Override
            public FavoritesPresenter create() {
                return new FavoritesPresenterImpl(interactor);
            }
        };
    }
}
