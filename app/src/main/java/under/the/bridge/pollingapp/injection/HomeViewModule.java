package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.interactor.HomeInteractor;
import under.the.bridge.pollingapp.interactor.impl.HomeInteractorImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.HomePresenter;
import under.the.bridge.pollingapp.presenter.impl.HomePresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class HomeViewModule {
    @Provides
    public HomeInteractor provideInteractor() {
        return new HomeInteractorImpl();
    }

    @Provides
    public PresenterFactory<HomePresenter> providePresenterFactory(@NonNull final HomeInteractor interactor) {
        return new PresenterFactory<HomePresenter>() {
            @NonNull
            @Override
            public HomePresenter create() {
                return new HomePresenterImpl(interactor);
            }
        };
    }
}
