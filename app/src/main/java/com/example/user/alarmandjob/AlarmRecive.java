package com.example.user.alarmandjob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by USER on 2017/10/31.
 */

public class AlarmRecive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        TostServiceHelper.initTostService(context);
    }
}
