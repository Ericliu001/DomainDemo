package com.example.ericliu.domaindemo.application;

import android.app.Application;

/**
 * Created by ericliu on 10/08/2016.
 */

public class MyApplication extends Application{
    public static Application mApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        if (mApplication == null) {
            mApplication = this;
        }
    }
}
