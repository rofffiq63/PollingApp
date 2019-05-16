package under.the.bridge.pollingapp.injection;

import under.the.bridge.pollingapp.view.impl.FeedsFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FeedsViewModule.class)
public interface FeedsViewComponent {
    void inject(FeedsFragment fragment);
}