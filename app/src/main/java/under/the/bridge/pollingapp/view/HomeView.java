package under.the.bridge.pollingapp.view;

import android.support.annotation.UiThread;

@UiThread
public interface HomeView extends BaseView {
    int fetchColor(int color);
}