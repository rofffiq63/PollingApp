package under.the.bridge.pollingapp.presenter.impl;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import under.the.bridge.pollingapp.interactor.TalksInteractor;
import under.the.bridge.pollingapp.presenter.TalksPresenter;
import under.the.bridge.pollingapp.view.TalksView;

public final class TalksPresenterImpl extends BasePresenterImpl<TalksView> implements TalksPresenter {
    /**
     * The interactor
     */
    @NonNull
    private final TalksInteractor mInteractor;

    // The view is available using the mView variable

    @Inject
    public TalksPresenterImpl(@NonNull TalksInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void onStart(boolean viewCreated) {
        super.onStart(viewCreated);

        // Your code here. Your view is available using mView and will not be null until next onStop()
    }

    @Override
    public void onStop() {
        // Your code here, mView will be null after this method until next onStart()

        super.onStop();
    }

    @Override
    public void onPresenterDestroyed() {
        /*
         * Your code here. After this method, your presenter (and view) will be completely destroyed
         * so make sure to cancel any HTTP call or database connection
         */

        super.onPresenterDestroyed();
    }
}
