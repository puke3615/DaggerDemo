package pk.daggerdemo.dagger.main;

import dagger.Module;
import dagger.Provides;
import pk.daggerdemo.button.Content;
import pk.daggerdemo.button.ContentImpl;
import pk.daggerdemo.dagger.activity.ActivityScope;

/**
 * @author zijiao
 * @version 2016/2/14
 * @Mark
 */
@Module
public class MainModule {

    @Provides
    @ActivityScope
    Content provideContent(ContentImpl contentImpl) {
        return contentImpl;
    }

}
