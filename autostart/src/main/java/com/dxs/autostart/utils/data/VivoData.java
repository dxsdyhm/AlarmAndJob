package com.dxs.autostart.utils.data;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.dxs.autostart.R;

import java.util.HashMap;

/**
 * Created by USER on 2017/11/9.
 */

public class VivoData extends BaseData{
    //vivo电量管理页面可能的情况
    //vivo x9
    private final static String[] battery1 = new String[]{"com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"};
    private final static int batteryCount = 1;

    //vivo自启动页面可能的情况
    private final static String[] AutoStar1 = new String[]{"com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"};
    //vivo x9
    private final static String[] AutoStar2 = new String[]{"com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity"};
    private final static int AutoStarCount = 1;

    @Override
    public HashMap<String, String> getBatterInfo() {
        HashMap<String, String> batterinfo = new HashMap<>();
        batterinfo.put("battery1", getSpliteName(battery1));
        return batterinfo;
    }

    @Override
    public HashMap<String, String> getAutoStarInfo() {
        HashMap<String, String> autoStart = new HashMap<>();
        autoStart.put("AutoStar1", getSpliteName(AutoStar1));
        autoStart.put("AutoStar2", getSpliteName(AutoStar2));
        return autoStart;
    }
}
