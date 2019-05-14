package under.the.bridge.pollingapp.injection;

import dagger.Component;
import under.the.bridge.pollingapp.view.impl.TalksFragment;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = TalksViewModule.class)
public interface TalksViewComponent {
    void inject(TalksFragment fragment);
}
