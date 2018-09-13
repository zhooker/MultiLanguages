package com.github.jokar.multilanguages.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.github.jokar.multilanguages.utils.AppLanguageHelper;

public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(AppLanguageHelper.wrapContext(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        AppLanguageHelper.setApplicationLanguage(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppLanguageHelper.setApplicationLanguage(this);
    }
}
