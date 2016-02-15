package pk.daggerdemo.dagger.activity;

import android.app.Activity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import pk.daggerdemo.dialog.DialogApi;
import pk.daggerdemo.dialog.DialogApiImpl;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
@Module
@ActivityScope
public class ActivityModule {

    private Activity mActivity;

    @Inject
    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    Activity activity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    DialogApi dialogApi() {
        return new DialogApiImpl(mActivity);
    }




}
