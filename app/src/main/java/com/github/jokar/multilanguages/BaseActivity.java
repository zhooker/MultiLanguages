package com.github.jokar.multilanguages;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.github.jokar.multilanguages.utils.AppLanguageHelper;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(AppLanguageHelper.wrapContext(newBase));
    }
}
