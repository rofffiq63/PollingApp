package under.the.bridge.pollingapp.injection;

import under.the.bridge.pollingapp.view.impl.FeedActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = FeedViewModule.class)
public interface FeedViewComponent {
    void inject(FeedActivity activity);
}