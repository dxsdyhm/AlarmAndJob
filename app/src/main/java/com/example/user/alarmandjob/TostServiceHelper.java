package com.example.user.alarmandjob;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;

import service.ToastJobService;
import service.TostService;

/**
 * Created by USER on 2017/10/31.
 */

public class TostServiceHelper {
    private static long SCEDULE_TIME = 60 * 1000;

    //启动一个定时弹窗的服务（模拟P2P服务）
    public static void initTostService(Context context) {
        Intent tostService = new Intent(context, TostService.class);
        context.startService(tostService);
    }

    /**
     * 启动定时任务
     *
     * @param context
     */
    public static void starReapte(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initScedule(context);
        } else {
            initAlarmmager(context);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void initScedule(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo = new JobInfo.Builder(1, new ComponentName(context.getPackageName(), ToastJobService.class.getName()))
                .setPeriodic(SCEDULE_TIME)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .build();
        jobScheduler.schedule(jobInfo);
    }

    public static void initAlarmmager(Context context) {
        //操作：发送一个广播，广播接收后Toast提示定时操作完成
        Intent intent = new Intent(context, AlarmRecive.class);
        intent.setAction("tost");
        PendingIntent sender =
                PendingIntent.getBroadcast(context, 0, intent, 0);
        //开始时间
        long firstime = SystemClock.elapsedRealtime();
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        //或者以下面方式简化
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, firstime, SCEDULE_TIME, sender);
    }
}
