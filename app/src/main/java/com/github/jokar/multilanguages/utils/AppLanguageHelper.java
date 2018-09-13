package com.github.jokar.multilanguages.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;

import com.github.jokar.multilanguages.R;

import java.util.Locale;

public class AppLanguageHelper {

    public static Locale getSystemLocale(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = LocaleList.getDefault().get(LocaleList.getDefault().size() - 1);
        } else {
            locale = Locale.getDefault();
        }
        return locale;
    }

    public static String getSelectLanguage(Context context) {
        switch (SPUtil.getInstance(context).getSelectLanguage()) {
            case 0:
                return context.getString(R.string.language_auto);
            case 1:
                return context.getString(R.string.language_cn);
            case 2:
                return context.getString(R.string.language_traditional);
            case 3:
            default:
                return context.getString(R.string.language_en);
        }
    }

    public static Locale getSetLanguageLocale(Context context) {

        switch (SPUtil.getInstance(context).getSelectLanguage()) {
            case 0:
                return getSystemLocale(context);
            case 1:
                return Locale.CHINA;
            case 2:
                return Locale.TAIWAN;
            case 3:
            default:
                return Locale.ENGLISH;
        }
    }

    public static void changeLanguage(Context context, int select) {
        SPUtil.getInstance(context).saveLanguage(select);
        setApplicationLanguage(context);
    }

    public static void setApplicationLanguage(Context context) {
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Configuration config = resources.getConfiguration();
            Locale locale = getSetLanguageLocale(context);
            config.locale = locale;
            resources.updateConfiguration(config, dm);
        }
    }

    public static Context wrapContext(Context context) {
        Locale locale = getSetLanguageLocale(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Resources res = context.getResources();
            Configuration config = new Configuration(res.getConfiguration());
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        }
        return context;
    }
}
