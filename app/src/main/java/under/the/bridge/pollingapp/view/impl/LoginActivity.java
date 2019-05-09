package under.the.bridge.pollingapp.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.DaggerLoginViewComponent;
import under.the.bridge.pollingapp.injection.LoginViewModule;
import under.the.bridge.pollingapp.model.PollLoginResponse;
import under.the.bridge.pollingapp.presenter.LoginPresenter;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.utils.GoogleHandler;
import under.the.bridge.pollingapp.utils.GoogleHandler.OnLoginListener;
import under.the.bridge.pollingapp.view.LoginView;

public final class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView, OnLoginListener {
    @Inject
    PresenterFactory<LoginPresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    GoogleHandler hiGoogle;
    @BindView(R.id.googleLogin)
    Button googleLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        hiGoogle = new GoogleHandler(this, this);
        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerLoginViewComponent.builder()
                .appComponent(parentComponent)
                .loginViewModule(new LoginViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<LoginPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        hiGoogle.fromActivityResult(requestCode, data);
    }

    @Override
    public void onSuccess(GoogleSignInAccount googleSignInAccount) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        System.out.println(gson.toJson(googleSignInAccount));
        hiGoogle.signOut();
        mPresenter.loginPollApi(
                googleSignInAccount.getId(),
                googleSignInAccount.getDisplayName(),
                googleSignInAccount.getEmail()
        );
    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.googleLogin)
    public void onClick() {
        hiGoogle.signIn(this);
    }

    @Override
    public <T> void onGeneralSuccess(T response) {
//        super.onGeneralSuccess(response);
        if (response instanceof PollLoginResponse){
            startActivity(new Intent(this, HomeActivity.class));
        }
    }
}
