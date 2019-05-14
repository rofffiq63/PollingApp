package under.the.bridge.pollingapp.presenter.impl;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import under.the.bridge.pollingapp.interactor.ProfileInteractor;
import under.the.bridge.pollingapp.presenter.ProfilePresenter;
import under.the.bridge.pollingapp.view.ProfileView;

public final class ProfilePresenterImpl extends BasePresenterImpl<ProfileView> implements ProfilePresenter {
    /**
     * The interactor
     */
    @NonNull
    private final ProfileInteractor mInteractor;

    // The view is available using the mView variable

    @Inject
    public ProfilePresenterImpl(@NonNull ProfileInteractor interactor) {
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
