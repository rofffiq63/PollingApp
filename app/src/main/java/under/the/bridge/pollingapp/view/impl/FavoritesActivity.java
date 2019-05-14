package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.DaggerFavoritesViewComponent;
import under.the.bridge.pollingapp.injection.FavoritesViewModule;
import under.the.bridge.pollingapp.presenter.FavoritesPresenter;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.view.FavoritesView;

public class FavoritesActivity extends BaseActivity<FavoritesPresenter, FavoritesView> implements FavoritesView {


    @Inject
    PresenterFactory<FavoritesPresenter> mPresenterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @NonNull
    @Override
    protected PresenterFactory<FavoritesPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerFavoritesViewComponent.builder()
                .appComponent(parentComponent)
                .favoritesViewModule(new FavoritesViewModule())
                .build()
                .inject(this);
    }
}
