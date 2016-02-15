package pk.daggerdemo.dagger;

import android.app.Application;

import javax.inject.Inject;

import pk.daggerdemo.dagger.application.AppComponent;
import pk.daggerdemo.dagger.application.AppModule;
import pk.daggerdemo.dagger.application.DaggerAppComponent;
import pk.daggerdemo.api.Api;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
public class DaggerApplication extends Application {

    private AppComponent mAppComponent;
    @Inject
    Api mApi;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
