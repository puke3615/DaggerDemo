package pk.daggerdemo.dagger.activity;

import android.app.Activity;

import dagger.Component;
import pk.daggerdemo.dagger.application.AppComponent;
import pk.daggerdemo.main.BaseActivity;
import pk.daggerdemo.dialog.DialogApi;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity baseActivity);

    Activity activity();

    DialogApi dialogApi();

}
