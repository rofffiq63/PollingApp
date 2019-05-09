package under.the.bridge.pollingapp.presenter;

import under.the.bridge.pollingapp.view.LoginView;

public interface LoginPresenter extends BasePresenter<LoginView> {

    void loginPollApi(String id, String displayName, String email);
}