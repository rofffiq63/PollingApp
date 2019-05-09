package under.the.bridge.pollingapp.injection;

import under.the.bridge.pollingapp.view.impl.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = HomeViewModule.class)
public interface HomeViewComponent {
    void inject(HomeActivity activity);
}