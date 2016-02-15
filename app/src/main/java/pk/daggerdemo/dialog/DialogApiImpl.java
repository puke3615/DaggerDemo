package pk.daggerdemo.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import javax.inject.Inject;

/**
 * @author zijiao
 * @version 2016/2/4
 * @Mark
 */
public class DialogApiImpl implements DialogApi {

    private Context mContext;
    private Dialog mDialog;

    @Inject
    public DialogApiImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void showLoadingDialog() {
        if (mDialog == null) {
            ProgressDialog dialog = new ProgressDialog(mContext);
            dialog.setMessage("Loading ...");
            mDialog = dialog;
            mDialog.setCanceledOnTouchOutside(true);
        }
        mDialog.show();
    }

    @Override
    public void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }
}
