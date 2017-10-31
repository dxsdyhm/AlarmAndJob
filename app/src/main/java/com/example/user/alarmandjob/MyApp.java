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
        initTostService();
    }

    //启动一个定时弹窗的服务（模拟P2P服务）
    private void initTostService() {
        Intent tostService=new Intent(this, TostService.class);
        this.startService(tostService);
    }
}
