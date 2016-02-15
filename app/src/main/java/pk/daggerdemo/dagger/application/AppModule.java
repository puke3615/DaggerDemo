package pk.daggerdemo.dagger.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pk.daggerdemo.dagger.DaggerApplication;
import pk.daggerdemo.api.Api;
import pk.daggerdemo.api.ApiImpl;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
@Module
public class AppModule {

    private DaggerApplication mApplication;

    public AppModule(DaggerApplication application) {
        this.mApplication = application;
    }

    @Provides
    DaggerApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Api provideApi(ApiImpl apiImpl) {
        return apiImpl;
    }

}
