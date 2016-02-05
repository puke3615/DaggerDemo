package pk.daggerdemo.application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author zijiao
 * @version 2016/2/4
 * @Mark
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    DaggerApplication application();

}
