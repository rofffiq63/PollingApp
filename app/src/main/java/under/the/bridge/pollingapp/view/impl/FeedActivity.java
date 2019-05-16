package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.view.FeedView;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.FeedPresenter;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.FeedViewModule;
import under.the.bridge.pollingapp.injection.DaggerFeedViewComponent;

import javax.inject.Inject;

public final class FeedActivity extends BaseActivity<FeedPresenter, FeedView> implements FeedView {
    @Inject
    PresenterFactory<FeedPresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerFeedViewComponent.builder()
                .appComponent(parentComponent)
                .feedViewModule(new FeedViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<FeedPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
