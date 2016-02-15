package pk.daggerdemo.dagger.main;

import dagger.Component;
import pk.daggerdemo.button.Content;
import pk.daggerdemo.dagger.activity.ActivityComponent;
import pk.daggerdemo.dagger.activity.ActivityModule;
import pk.daggerdemo.dagger.activity.ActivityScope;
import pk.daggerdemo.main.MainActivity;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
@ActivityScope
@Component(modules = {MainModule.class, ActivityModule.class})
public interface MainComponent extends ActivityComponent {

    void inject(MainActivity mainActivity);

    Content content();

}
