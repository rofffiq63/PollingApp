package under.the.bridge.pollingapp.view.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.DaggerProfileViewComponent;
import under.the.bridge.pollingapp.injection.ProfileViewModule;
import under.the.bridge.pollingapp.presenter.ProfilePresenter;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.view.ProfileView;

public class ProfileFragment extends BaseFragment<ProfilePresenter, ProfileView> implements ProfileView, View.OnClickListener {
    @Inject
    PresenterFactory<ProfilePresenter> mPresenterFactory;

    @BindView(R.id.tv_favorites)
    TextView tvFavorites;

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        tvFavorites.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_favorites:
                startActivity(new Intent(context, FavoritesActivity.class));
                break;
        }
    }

    @NonNull
    @Override
    protected PresenterFactory<ProfilePresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerProfileViewComponent.builder()
                .appComponent(parentComponent)
                .profileViewModule(new ProfileViewModule())
                .build()
                .inject(this);
    }


}
