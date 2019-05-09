package under.the.bridge.pollingapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.tree.rh.googlelib.OnLoginListener;

public class GoogleHandler {
    private Context context;
    private Activity activity;
    private static final String TAG = "HiGoogleLog";
    private static final int RC_SIGN_IN = 3012;
    private GoogleSignInClient mGoogleSignInClient;
    private OnLoginListener onLoginListener;

    public GoogleHandler(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        this.initGoogle();
    }

    public GoogleHandler(Context context, Activity activity, String accessToken) {
        this.context = context;
        this.activity = activity;
        this.initGoogle(accessToken);
    }

    private void initGoogle() {
        GoogleSignInOptions gso = (new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)).requestEmail().build();
        this.mGoogleSignInClient = GoogleSignIn.getClient(this.context, gso);
    }

    private void initGoogle(String accessToken) {
        GoogleSignInOptions gso = (new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)).requestEmail().requestIdToken(accessToken).build();
        this.mGoogleSignInClient = GoogleSignIn.getClient(this.context, gso);
    }

    public void signIn(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
        Intent signInIntent = this.mGoogleSignInClient.getSignInIntent();
        this.activity.startActivityForResult(signInIntent, 3012);
    }

    public void signOut() {
        mGoogleSignInClient.signOut();
    }

    public void fromActivityResult(int requestCode, Intent data) {
        if (requestCode == 3012) {
            Task task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = (GoogleSignInAccount) task.getResult(ApiException.class);
                this.onLoginListener.onSuccess(account);
            } catch (ApiException var5) {
                this.onLoginListener.onFailed(var5 + "");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

    }

    public interface OnLoginListener {
        void onSuccess(GoogleSignInAccount var1);

        void onFailed(String var1);
    }
}
