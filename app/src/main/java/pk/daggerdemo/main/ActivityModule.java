package pk.daggerdemo.main;

import android.app.Activity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import pk.daggerdemo.main.compontent.Api;
import pk.daggerdemo.main.compontent.ApiImpl;
import pk.daggerdemo.main.compontent.DialogApi;
import pk.daggerdemo.main.compontent.DialogApiImpl;

/**
 * @author zijiao
 * @version 2016/2/4
 * @Mark
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    @Inject
    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity activity() {
        return mActivity;
    }

    public void inject(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    public Api api() {
        return new ApiImpl();
    }

    @Provides
    @ActivityScope
    public DialogApi dialogApi() {
        return new DialogApiImpl(mActivity);
    }

}
