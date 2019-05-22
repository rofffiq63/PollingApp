package under.the.bridge.pollingapp.presenter;

import under.the.bridge.pollingapp.view.HomeView;

public interface HomePresenter extends BasePresenter<HomeView> {

    void getPolls();
}