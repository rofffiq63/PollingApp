package under.the.bridge.pollingapp.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.view.SplashView;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.SplashPresenter;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.SplashViewModule;
import under.the.bridge.pollingapp.injection.DaggerSplashViewComponent;

import javax.inject.Inject;

public final class SplashActivity extends BaseActivity<SplashPresenter, SplashView> implements SplashView {
    @Inject
    PresenterFactory<SplashPresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        }, 2000);
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerSplashViewComponent.builder()
                .appComponent(parentComponent)
                .splashViewModule(new SplashViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<SplashPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
