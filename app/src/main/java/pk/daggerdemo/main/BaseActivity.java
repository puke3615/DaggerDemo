package pk.daggerdemo.main;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import pk.daggerdemo.dagger.DaggerApplication;
import pk.daggerdemo.dagger.activity.ActivityComponent;
import pk.daggerdemo.dagger.activity.ActivityModule;
import pk.daggerdemo.dagger.activity.DaggerActivityComponent;
import pk.daggerdemo.dagger.application.AppComponent;
import pk.daggerdemo.dialog.DialogApi;


/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
public class BaseActivity extends Activity {

    @Inject
    DialogApi mDialogApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
    }

    protected AppComponent getAppComponent() {
        return ((DaggerApplication) getApplication()).getAppComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

}
