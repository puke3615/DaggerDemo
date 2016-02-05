package pk.daggerdemo.main.compontent;

import javax.inject.Inject;

/**
 * @author zijiao
 * @version 2016/2/4
 * @Mark
 */
public class ApiImpl implements Api {

    @Inject
    public ApiImpl() {

    }

    @Override
    public String handle(int a) {
        return String.format("【%d】", a);
    }
}
