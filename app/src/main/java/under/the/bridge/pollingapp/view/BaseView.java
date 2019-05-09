package under.the.bridge.pollingapp.view;

import under.the.bridge.pollingapp.utils.NetworkError;

public interface BaseView {

    void onGeneralFailure(NetworkError networkError);

    <T> void onGeneralSuccess(T response);

}
