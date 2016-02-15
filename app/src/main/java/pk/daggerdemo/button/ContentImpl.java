package pk.daggerdemo.button;

import javax.inject.Inject;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
public class ContentImpl implements Content {

    @Inject
    public ContentImpl() {

    }

    @Override
    public String getDialogText() {
        return "显示对话框";
    }

    @Override
    public String getApiText() {
        return "显示Api";
    }
}
