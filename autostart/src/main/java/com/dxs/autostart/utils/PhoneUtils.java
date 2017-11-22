package com.dxs.autostart.utils;

import android.os.Build;

/**
 * Created by USER on 2017/11/8.
 */

public class PhoneUtils {

    public static String getPhoneInfo(){
        StringBuilder info=new StringBuilder();
        info.append("手机厂商:"+ Build.MANUFACTURER);
        info.append("\n");
        info.append("Android API:"+ Build.VERSION.SDK_INT);
        info.append("\n");
        return info.toString();
    }
}
