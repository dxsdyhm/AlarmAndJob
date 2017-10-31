package com.example.user.alarmandjob;

import android.app.Application;
import android.content.Intent;

import service.TostService;

/**
 * Created by USER on 2017/10/31.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TostServiceHelper.initAlarmmager(this);
    }
}
