package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.view.HomeView;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.HomePresenter;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.HomeViewModule;
import under.the.bridge.pollingapp.injection.DaggerHomeViewComponent;

import javax.inject.Inject;

public final class HomeActivity extends BaseActivity<HomePresenter, HomeView> implements HomeView {
    @Inject
    PresenterFactory<HomePresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerHomeViewComponent.builder()
                .appComponent(parentComponent)
                .homeViewModule(new HomeViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<HomePresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
