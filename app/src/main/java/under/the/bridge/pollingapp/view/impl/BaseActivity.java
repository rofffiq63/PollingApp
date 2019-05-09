package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import under.the.bridge.pollingapp.PollApp;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.presenter.loader.PresenterLoader;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.presenter.BasePresenter;
import under.the.bridge.pollingapp.utils.NetworkError;
import under.the.bridge.pollingapp.view.BaseView;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseActivity<P extends BasePresenter<V>, V> extends AppCompatActivity implements LoaderManager.LoaderCallbacks<P>, BaseView {
    /**
     * Do we need to call {@link #doStart()} from the {@link #onLoadFinished(Loader, BasePresenter)} method.
     * Will be true if presenter wasn't loaded when {@link #onStart()} is reached
     */
    private final AtomicBoolean mNeedToCallStart = new AtomicBoolean(false);
    /**
     * The presenter for this view
     */
    @Nullable
    protected P mPresenter;
    /**
     * Is this the first start of the activity (after onCreate)
     */
    private boolean mFirstStart;

    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gson = new GsonBuilder().setPrettyPrinting().create();

        mFirstStart = true;

        injectDependencies();

        getSupportLoaderManager().initLoader(0, null, this).startLoading();
    }

    private void injectDependencies() {
        setupComponent(((PollApp) getApplication()).getAppComponent());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mPresenter == null) {
            mNeedToCallStart.set(true);
        } else {
            doStart();
        }
    }

    /**
     * Call the presenter callbacks for onStart
     */
    @SuppressWarnings("unchecked")
    private void doStart() {
        assert mPresenter != null;

        mPresenter.onViewAttached((V) this);

        mPresenter.onStart(mFirstStart);

        mFirstStart = false;
    }

    @Override
    protected void onStop() {
        if (mPresenter != null) {
            mPresenter.onStop();

            mPresenter.onViewDetached();
        }

        super.onStop();
    }

    @Override
    public final Loader<P> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<>(this, getPresenterFactory());
    }

    @Override
    public final void onLoadFinished(Loader<P> loader, P presenter) {
        mPresenter = presenter;

        if (mNeedToCallStart.compareAndSet(true, false)) {
            doStart();
        }
    }

    @Override
    public final void onLoaderReset(Loader<P> loader) {
        mPresenter = null;
    }

    /**
     * Get the presenter factory implementation for this view
     *
     * @return the presenter factory
     */
    @NonNull
    protected abstract PresenterFactory<P> getPresenterFactory();

    /**
     * Setup the injection component for this view
     *
     * @param appComponent the app component
     */
    protected abstract void setupComponent(@NonNull AppComponent appComponent);

    @Override
    public void onGeneralFailure(NetworkError networkError) {
        Toast.makeText(this, networkError.getResponse().getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public <T> void onGeneralSuccess(T response) {

    }
}
