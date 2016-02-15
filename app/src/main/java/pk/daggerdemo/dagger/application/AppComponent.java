package pk.daggerdemo.dagger.application;

import javax.inject.Singleton;

import dagger.Component;
import pk.daggerdemo.dagger.DaggerApplication;
import pk.daggerdemo.api.Api;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(DaggerApplication application);

    DaggerApplication application();

    Api api();

}
