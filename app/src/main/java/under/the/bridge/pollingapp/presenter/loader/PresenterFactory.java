package under.the.bridge.pollingapp.presenter.loader;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.presenter.BasePresenter;

/**
 * Factory to implement to create a presenter
 */
public interface PresenterFactory<T extends BasePresenter> {
    @NonNull
    T create();
}
