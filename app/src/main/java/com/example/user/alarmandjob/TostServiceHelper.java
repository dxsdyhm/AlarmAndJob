package com.example.user.alarmandjob;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import service.TostService;

/**
 * Created by USER on 2017/10/31.
 */

public class TostServiceHelper {

    //启动一个定时弹窗的服务（模拟P2P服务）
    public static void initTostService(Context context) {
        Intent tostService = new Intent(context, TostService.class);
        context.startService(tostService);
    }

    public static void initAlarmmager(Context context) {
        //操作：发送一个广播，广播接收后Toast提示定时操作完成
        Intent intent = new Intent(context, AlarmRecive.class);
        intent.setAction("tost");
        PendingIntent sender =
                PendingIntent.getBroadcast(context, 0, intent, 0);
        //开始时间
        long firstime= SystemClock.elapsedRealtime();
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        //或者以下面方式简化
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, firstime, 60*1000, sender);
    }
}
