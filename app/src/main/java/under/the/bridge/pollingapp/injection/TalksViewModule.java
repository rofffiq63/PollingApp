package under.the.bridge.pollingapp.injection;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import under.the.bridge.pollingapp.interactor.TalksInteractor;
import under.the.bridge.pollingapp.interactor.impl.TalksInteractorImpl;
import under.the.bridge.pollingapp.presenter.TalksPresenter;
import under.the.bridge.pollingapp.presenter.impl.TalksPresenterImpl;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;

@Module
public final class TalksViewModule {
    @Provides
    public TalksInteractor provideInteractor() {
        return new TalksInteractorImpl();
    }

    @Provides
    public PresenterFactory<TalksPresenter> providePresenterFactory(@NonNull final TalksInteractor interactor) {
        return new PresenterFactory<TalksPresenter>() {
            @NonNull
            @Override
            public TalksPresenter create() {
                return new TalksPresenterImpl(interactor);
            }
        };
    }
}
