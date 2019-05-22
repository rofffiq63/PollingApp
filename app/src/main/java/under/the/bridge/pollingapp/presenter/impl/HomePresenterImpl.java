package under.the.bridge.pollingapp.presenter.impl;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.model.PollingData;
import under.the.bridge.pollingapp.presenter.HomePresenter;
import under.the.bridge.pollingapp.utils.EndPointBridgeService;
import under.the.bridge.pollingapp.utils.NetworkError;
import under.the.bridge.pollingapp.view.HomeView;
import under.the.bridge.pollingapp.interactor.HomeInteractor;

import javax.inject.Inject;

public final class HomePresenterImpl extends BasePresenterImpl<HomeView> implements HomePresenter {
    /**
     * The interactor
     */
    @NonNull
    private final HomeInteractor mInteractor;

    // The view is available using the mView variable

    @Inject
    public HomePresenterImpl(@NonNull HomeInteractor interactor) {
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

    @Override
    public void getPolls() {
        subscriptions.add(endPointBridgeService.getPolls(new EndPointBridgeService.GetCallbackResponse<PollingData>() {
            @Override
            public void onSuccess(PollingData response) {
                mView.onGeneralSuccess(response);
            }

            @Override
            public void onError(NetworkError networkError) {
                mView.onGeneralFailure(networkError);
            }
        }));
    }
}