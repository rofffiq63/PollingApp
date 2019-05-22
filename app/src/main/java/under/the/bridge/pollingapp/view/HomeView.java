package under.the.bridge.pollingapp.view;

import android.support.annotation.UiThread;

import under.the.bridge.pollingapp.model.PollingData;

@UiThread
public interface HomeView extends BaseView {

    int fetchColor(int color);
}
