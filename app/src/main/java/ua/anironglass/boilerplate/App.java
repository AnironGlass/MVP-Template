package ua.anironglass.boilerplate;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.leakcanary.RefWatcher;

import ua.anironglass.boilerplate.injection.components.ApplicationComponent;
import ua.anironglass.boilerplate.injection.components.DaggerApplicationComponent;
import ua.anironglass.boilerplate.injection.modules.ApplicationModule;

public class App extends Application {

    protected ApplicationComponent mApplicationComponent;

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (null == mApplicationComponent) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    @NonNull
    public RefWatcher getRefWatcher() {
        return RefWatcher.DISABLED;
    }

}