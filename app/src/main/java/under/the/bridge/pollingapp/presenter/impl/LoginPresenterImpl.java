package under.the.bridge.pollingapp.presenter.impl;

import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.model.PollLoginResponse;
import under.the.bridge.pollingapp.presenter.LoginPresenter;
import under.the.bridge.pollingapp.utils.EndPointBridgeService;
import under.the.bridge.pollingapp.utils.NetworkError;
import under.the.bridge.pollingapp.view.LoginView;
import under.the.bridge.pollingapp.interactor.LoginInteractor;

import javax.inject.Inject;

public final class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter {
    /**
     * The interactor
     */
    @NonNull
    private final LoginInteractor mInteractor;

    // The view is available using the mView variable

    @Inject
    public LoginPresenterImpl(@NonNull LoginInteractor interactor) {
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
    public void loginPollApi(String id, String displayName, String email) {
        subscriptions.add(endPointBridgeService.loginPoll(new EndPointBridgeService.GetCallbackResponse<PollLoginResponse>() {
            @Override
            public void onSuccess(PollLoginResponse response) {
                mView.onGeneralSuccess(response);
            }

            @Override
            public void onError(NetworkError networkError) {
                mView.onGeneralFailure(networkError);
            }
        }, id, displayName, email));
    }
}