package under.the.bridge.pollingapp.injection;


import dagger.Component;
import under.the.bridge.pollingapp.view.impl.FavoritesActivity;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = FavoritesViewModule.class)
public interface FavoritesViewComponent {
    void inject(FavoritesActivity activity);
}
