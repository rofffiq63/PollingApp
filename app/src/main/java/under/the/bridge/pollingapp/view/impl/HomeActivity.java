package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.DaggerHomeViewComponent;
import under.the.bridge.pollingapp.injection.HomeViewModule;
import under.the.bridge.pollingapp.presenter.HomePresenter;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.view.HomeView;

public final class HomeActivity extends BaseActivity<HomePresenter, HomeView> implements HomeView,
        AHBottomNavigation.OnTabSelectedListener {
    private static final String TAG_TALKS = "tagtalks";
    private static final String TAG_MOMENT = "tagmoment";
    private static final String TAG_SEARCH = "tagsearch";
    private static final String TAG_FAVORITES = "tagfavorites";
    private static final String TAG_PROFILE = "tagprofile";
    private static final String TAG_FEEDS = "tagfeeds";
    private static final String BUNDLE_TAG = "lasttagselected";
    // Your presenter is available using the mPresenter variable\
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottom;
    private String LAST_TAG_SELECTED = TAG_FEEDS;

    @Inject
    PresenterFactory<HomePresenter> mPresenterFactory;
    private TalksFragment talksFragment;
    private FeedsFragment feedsFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
        setupBottom();

        if (savedInstanceState == null) {
            feedsFragment = new FeedsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, feedsFragment).commit();
        } else {
            LAST_TAG_SELECTED = savedInstanceState.getString(BUNDLE_TAG);
            if (LAST_TAG_SELECTED != null) selectFragmentState(LAST_TAG_SELECTED);
        }
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

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

    private void setupBottom() {
        AHBottomNavigationItem feeds = new AHBottomNavigationItem("", AppCompatResources.getDrawable(this, R.drawable.ic_message_black));
        AHBottomNavigationItem adds = new AHBottomNavigationItem("", AppCompatResources.getDrawable(this, R.drawable.ic_add_black));
        AHBottomNavigationItem search = new AHBottomNavigationItem("", AppCompatResources.getDrawable(this, R.drawable.ic_search_black));
        AHBottomNavigationItem favorites = new AHBottomNavigationItem("", AppCompatResources.getDrawable(this, R.drawable.ic_favorite_border_black));
        AHBottomNavigationItem profile = new AHBottomNavigationItem("", AppCompatResources.getDrawable(this, R.drawable.ic_person_outline_black));

        bottom.addItem(feeds);
        bottom.addItem(adds);
        bottom.addItem(search);
        bottom.addItem(favorites);
        bottom.addItem(profile);

        bottom.setCurrentItem(0);
        bottom.setDefaultBackgroundColor(fetchColor(R.color.white));
        bottom.setAccentColor(fetchColor(R.color.selector_item_color));
        bottom.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottom.setForceTint(false);
        bottom.setOnTabSelectedListener(this);
    }

    @Override
    public int fetchColor(int color) {
        return ContextCompat.getColor(this, color);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        switch (position) {
            case 0:
                if (bottom.getCurrentItem() != 0) {
                    LAST_TAG_SELECTED = TAG_FEEDS;
                    feedsFragment = new FeedsFragment();
                    callFragment(feedsFragment, TAG_FEEDS);
                }
                break;
            case 1:
                break;
            case 2:
                if (bottom.getCurrentItem() != 1) {
                    LAST_TAG_SELECTED = TAG_SEARCH;
                    //fragmentCart = new CartFragment();
                    //callFragment(fragmentCart, TAG_LEARN);
                }
                break;
            case 3:
                break;
            case 4:
                if (bottom.getCurrentItem() != 2) {
                    LAST_TAG_SELECTED = TAG_PROFILE;
                    profileFragment = new ProfileFragment();
                    callFragment(profileFragment, TAG_PROFILE);
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(BUNDLE_TAG, LAST_TAG_SELECTED);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void callFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_main, fragment, tag).commit();
    }

    private void selectFragmentState(String lastTagSelected) {
        switch (lastTagSelected) {
            case TAG_TALKS:
                talksFragment = (TalksFragment)
                        getSupportFragmentManager().findFragmentByTag(TAG_TALKS);
                bottom.setCurrentItem(0);
                break;
            case TAG_PROFILE:
                profileFragment = (ProfileFragment)
                        getSupportFragmentManager().findFragmentByTag(TAG_PROFILE);
                bottom.setCurrentItem(4);
                break;
        }
    }
}
