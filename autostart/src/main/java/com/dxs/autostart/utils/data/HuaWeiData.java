package com.dxs.autostart.utils.data;

import java.util.HashMap;

/**
 * Created by USER on 2017/11/8.
 */
//    安卓版本 EMUI版本  Auto    Battery
//    4.0	  1.0
//    4.1	  1.0
//    4.1     1.5
//    4.1     2.0
//    4.2.2   1.6
//    4.2.2   2.0
//    4.3     1.6
//    4.3	  2.0
//    4.4.2	  2.3
//    4.4.2	  3.0
//    5.1     3.1       √2        √1
//    6.0	  4.0
//    6.0	  4.1       √1        √1
//    7.0	  5.0       √1        √1
//    8.0	  8.0
public class HuaWeiData extends BaseData {

    //华为电量管理页面可能的情况
    private final static String[] battery1 = new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"};
    private final static int batteryCount = 1;

    //华为自启动页面可能的情况
    //EMUI 5.0  Android 7.0
    private final static String[] AutoStar1 = new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"};
    //EMUI 3.1  Android 5.1
    private final static String[] AutoStar2 = new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity"};
    //优先使用关联启动
    private final static String[] AutoStar3=new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupAwakedAppListActivity"};
    private final static int AutoStarCount = 2;
    @Override
    public HashMap<String, String> getBatterInfo() {
        HashMap<String, String> batterinfo = new HashMap<>();
        batterinfo.put("battery1", getSpliteName(battery1));
        return batterinfo;
    }

    @Override
    public HashMap<String, String> getAutoStarInfo() {
        HashMap<String, String> autoStart = new HashMap<>();
        autoStart.put("AutoStar3", getSpliteName(AutoStar3));
        autoStart.put("AutoStar1", getSpliteName(AutoStar1));
        autoStart.put("AutoStar2", getSpliteName(AutoStar2));
        return autoStart;
    }
}
