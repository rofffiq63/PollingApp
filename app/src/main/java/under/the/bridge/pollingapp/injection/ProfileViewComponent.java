package under.the.bridge.pollingapp.injection;

import dagger.Component;
import under.the.bridge.pollingapp.view.impl.ProfileFragment;

@FragmentScope

@Component(dependencies = AppComponent.class, modules = ProfileViewModule.class)
public interface ProfileViewComponent {
    void inject(ProfileFragment fragment);
}
