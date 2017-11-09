package com.dxs.autostart.utils.data;

import java.util.HashMap;

/**
 * Created by USER on 2017/11/8.
 */

public class MeizuData extends BaseData {

    //魅族电量管理页面可能的情况（没有电量设置）
    private final static String[] battery1 = new String[]{"com.meizu.safe", "null"};
    private final static int batteryCount = 1;

    //魅族自启动页面可能的情况
    private final static String[] AutoStar1 = new String[]{"com.meizu.safe", "com.meizu.safe.permission.SmartBGActivity"};
    //魅蓝Note  5.1
    private final static String[] AutoStar2 = new String[]{"com.meizu.safe", "com.meizu.safe.security.HomeActivity"};
    private final static int AutoStarCount = 1;

    @Override
    public HashMap<String, String> getBatterInfo() {
        HashMap<String, String> batterinfo = new HashMap<>();
        //batterinfo.put("battery1", getSpliteName(battery1));
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
