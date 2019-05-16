package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.view.FeedsView;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.FeedsPresenter;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.FeedsViewModule;
import under.the.bridge.pollingapp.injection.DaggerFeedsViewComponent;

import javax.inject.Inject;

public final class FeedsFragment extends BaseFragment<FeedsPresenter, FeedsView> implements FeedsView {
    @Inject
    PresenterFactory<FeedsPresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    public FeedsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feeds, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerFeedsViewComponent.builder()
                .appComponent(parentComponent)
                .feedsViewModule(new FeedsViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<FeedsPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
