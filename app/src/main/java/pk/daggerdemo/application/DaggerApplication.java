package pk.daggerdemo.application;

import android.app.Application;

/**
 * @author zijiao
 * @version 2016/2/4
 * @Mark
 */
public class DaggerApplication extends Application {

    private ApplicationComponent mApplicationCompontent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationCompontent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationCompontent;
    }

}
