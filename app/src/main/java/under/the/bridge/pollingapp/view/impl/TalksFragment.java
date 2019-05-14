package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.DaggerTalksViewComponent;
import under.the.bridge.pollingapp.injection.TalksViewModule;
import under.the.bridge.pollingapp.presenter.TalksPresenter;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.view.SplashView;
import under.the.bridge.pollingapp.view.TalksView;

public final class TalksFragment extends BaseFragment<TalksPresenter, TalksView> implements SplashView {

    @Inject
    PresenterFactory<TalksPresenter> mPresenterFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_talks, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @NonNull
    @Override
    protected PresenterFactory<TalksPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerTalksViewComponent.builder()
                .appComponent(parentComponent)
                .talksViewModule(new TalksViewModule())
                .build()
                .inject(this);
    }
}
