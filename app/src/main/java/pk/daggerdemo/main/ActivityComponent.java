package pk.daggerdemo.main;

import android.app.Activity;

import dagger.Component;
import pk.daggerdemo.application.ApplicationComponent;
import pk.daggerdemo.main.compontent.Api;
import pk.daggerdemo.main.compontent.DialogApi;

/**
 * @author zijiao
 * @version 2016/2/4
 * @Mark
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    Activity activity();

    void inject(Activity activity);

    Api api();

    DialogApi dialogApi();

}
