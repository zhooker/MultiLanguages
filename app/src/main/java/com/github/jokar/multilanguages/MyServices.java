package com.github.jokar.multilanguages;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.github.jokar.multilanguages.utils.AppLanguageHelper;

public class MyServices extends IntentService {

    public MyServices() {
        super("MyServices");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(AppLanguageHelper.wrapContext(base));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), getString(R.string.service_create), Toast.LENGTH_SHORT).show();
    }
}
