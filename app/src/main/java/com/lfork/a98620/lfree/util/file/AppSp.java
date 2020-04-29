package com.lfork.a98620.lfree.util.file;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.lfork.a98620.lfree.BuildConfig;
import com.lfork.a98620.lfree.base.FreeApplication;

import java.util.Set;


public class AppSp {

    private static final SharedPreferences I = PreferenceManager.getDefaultSharedPreferences(FreeApplication.getContext());
    private static final Editor O = I.edit();
    private static final String KEY_APP_VERSION_CODE = "key_app_version_code";

    public static void init() {
        int v = I.getInt(KEY_APP_VERSION_CODE, -1);
        if (v != BuildConfig.VERSION_CODE) {
            O.putInt(KEY_APP_VERSION_CODE, BuildConfig.VERSION_CODE);
        }
    }


    @Nullable
    public static String getString(String key, @Nullable String defValue) {
        return I.getString(key, defValue);
    }

    public static int getInt(String key, int defValue) {
        return I.getInt(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        return I.getLong(key, defValue);
    }

    public static float getFloat(String key, float defValue) {
        return I.getFloat(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return I.getBoolean(key, defValue);
    }


    public static Set<String> getStringSet(String key) {
        return I.getStringSet(key, null);
    }

    public static void putStringSet(String key,Set<String> sets) {
         O.putStringSet(key,sets).apply();
    }


    public static Editor remove(String key) {
        O.remove(key);
        return O;
    }

    public static boolean contains(String key) {
        return I.contains(key);
    }

    ///////// 装饰了以下函数，自动apply ////////
    public static Editor putString(String key, @Nullable String value) {
        O.putString(key, value).apply();
        return O;
    }

    public static Editor putString(String key, @Nullable String value, boolean immediatele) {
        if (immediatele) {
            O.putString(key, value).commit();
        } else {
            O.putString(key, value).apply();
        }
        return O;
    }


    public static Editor putInt(String key, int value) {
        O.putInt(key, value).apply();
        return O;
    }

    public static Editor putLong(String key, long value) {
        O.putLong(key, value).apply();
        return O;
    }

    public static Editor putFloat(String key, float value) {
        O.putFloat(key, value).apply();
        return O;
    }

    public static Editor putBoolean(String key, boolean value) {
        O.putBoolean(key, value).apply();
        return O;
    }

    public static void putBooleanImmediate(String key, boolean value) {
        O.putBoolean(key, value).commit();
    }
}

