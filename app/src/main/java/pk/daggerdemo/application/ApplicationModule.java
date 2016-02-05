package pk.daggerdemo.application;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * @author zijiao
 * @version 2016/2/4
 * @Mark
 */
@Module
public class ApplicationModule {

    private DaggerApplication mDaggerApplication;

    @Inject
    public ApplicationModule(DaggerApplication daggerApplication) {
        this.mDaggerApplication = daggerApplication;
    }

    @Provides
    DaggerApplication daggerApplication() {
        return mDaggerApplication;
    }

}
