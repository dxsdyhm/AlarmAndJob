package com.dxs.autostart.utils.data;

import java.util.HashMap;

/**
 * Created by USER on 2017/11/8.
 */

public class LeTVData extends BaseData {

    //乐视电量管理页面可能的情况
    private final static String[] battery1 = new String[]{"com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"};
    private final static int batteryCount = 1;

    //乐视自启动页面可能的情况
    private final static String[] AutoStar1 = new String[]{"com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"};
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
        return autoStart;
    }
}
