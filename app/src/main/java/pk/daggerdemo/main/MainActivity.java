package pk.daggerdemo.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pk.daggerdemo.R;
import pk.daggerdemo.application.ApplicationComponent;
import pk.daggerdemo.application.DaggerApplication;
import pk.daggerdemo.main.compontent.Api;
import pk.daggerdemo.main.compontent.DialogApi;

public class MainActivity extends Activity {

    private DialogApi api;
    private Api a;
    private Button show, dismiss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationComponent applicationComponent = ((DaggerApplication) getApplication()).getApplicationComponent();
        ActivityComponent activityCompontent = DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(new ActivityModule(this))
                .build();
        api = activityCompontent.dialogApi();


        setContentView(R.layout.activity_main);
        show = (Button) findViewById(R.id.show);
        dismiss = (Button) findViewById(R.id.dismiss);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass()) {
                    api.showLoadingDialog();
                }
            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass()) {
                    api.dismiss();
                }
            }
        });

    }

    private boolean pass() {
        if (api == null) {
            T("api == null");
            return false;
        }
        return true;
    }

    public void T(Object s) {
        Toast.makeText(this, s + "", Toast.LENGTH_SHORT).show();
    }

}
