package under.the.bridge.pollingapp.presenter.impl;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.File;

import rx.subscriptions.CompositeSubscription;
import under.the.bridge.pollingapp.presenter.BasePresenter;
import under.the.bridge.pollingapp.utils.EndPointBridgeService;
import under.the.bridge.pollingapp.utils.Network;
import under.the.bridge.pollingapp.utils.SessionManager;
import under.the.bridge.pollingapp.view.impl.BaseActivity;
import under.the.bridge.pollingapp.view.impl.BaseFragment;

/**
 * Abstract presenter implementation that contains base implementation for other presenters.
 * Subclasses must call super for all {@link BasePresenter} method overriding.
 */
public abstract class BasePresenterImpl<V> implements BasePresenter<V> {
    /**
     * The view
     */
    @Nullable
    protected V mView;
    private Activity activity;
    private SessionManager sessionManager;
    public EndPointBridgeService endPointBridgeService;
    public CompositeSubscription subscriptions;

    @Override
    public void onViewAttached(@NonNull V view) {
        activity = new Activity();
        if (view instanceof BaseActivity) {
            activity = (BaseActivity) view;
        } else if (view instanceof BaseFragment) {
            activity = ((BaseFragment) view).getActivity();
        }
        File cacheFile = new File(activity.getCacheDir(), "responses");
        mView = view;
        sessionManager = new SessionManager(activity);
//        iDatabaseManager = new DatabaseManager(activity, sessionManager);
        endPointBridgeService = Network.builder(cacheFile, activity);
        subscriptions = new CompositeSubscription();
    }


    @Override
    public void onStart(boolean viewCreated) {

    }

    @Override
    public void onStop() {

    }


    @Override
    public void onViewDetached() {
        mView = null;
    }

    @Override
    public void onPresenterDestroyed() {

    }
}
