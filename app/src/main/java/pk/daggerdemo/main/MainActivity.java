package pk.daggerdemo.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import pk.daggerdemo.R;
import pk.daggerdemo.api.Api;
import pk.daggerdemo.button.Content;
import pk.daggerdemo.dagger.activity.ActivityModule;
import pk.daggerdemo.dagger.main.DaggerMainComponent;
import pk.daggerdemo.dagger.main.MainComponent;
import pk.daggerdemo.dagger.main.MainModule;

public class MainActivity extends BaseActivity {

    private Button showDialog, format;
    @Inject
    Content content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AppComponent applicationComponent = ((DaggerApplication) getApplication()).getAppComponent();
//        ActivityComponent activityCompontent = DaggerActivityComponent.builder()
//                .appComponent(applicationComponent)
//                .activityModule(new ActivityModule(this))
//                .build();
//        api = activityCompontent.dialogApi();
//        getActivityComponent().inject(this);
        MainComponent mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .activityModule(new ActivityModule(this))
                .build();
        //content = mainComponent.content();
        mainComponent.inject(this);


        setContentView(R.layout.activity_main);
        showDialog = (Button) findViewById(R.id.showDialog);
        format = (Button) findViewById(R.id.format);
        if (content != null) {
            showDialog.setText(content.getDialogText());
            format.setText(content.getApiText());
        }

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass()) {
                    mDialogApi.showLoadingDialog();
                }
            }
        });

        format.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 11;
                Api api = getAppComponent().api();
                T(api.handle(a));
            }
        });

    }

    private boolean pass() {
        if (mDialogApi == null) {
            T("api == null");
            return false;
        }
        return true;
    }

    public void T(Object s) {
        Toast.makeText(this, s + "", Toast.LENGTH_SHORT).show();
    }

}
