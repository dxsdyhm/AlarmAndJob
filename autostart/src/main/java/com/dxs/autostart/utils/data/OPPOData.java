package com.dxs.autostart.utils.data;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.dxs.autostart.R;

import java.util.HashMap;

/**
 * Created by USER on 2017/11/8.
 */

public class OPPOData extends BaseData {
    //OPPO电量管理页面可能的情况（没有电量设置）,直接进入指定APP的设置页，设置后不起作用，改为用户自选
    //猜测是输入的参数系统没有识别（需要查看系统源码，按系统方式输入参数）
//    private final static String[] battery1 = new String[]{"com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerAppsBgSetting"};
    private final static String[] battery1 = new String[]{"com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"};
    private final static int batteryCount = 1;

    //OPPO自启动页面可能的情况
    private final static String[] AutoStar1 = new String[]{"com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity"};
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

    @Override
    public Intent getBatterIntent(Context mContext) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String[] find=getUseBatterInfo(mContext);
        ComponentName name=new ComponentName(find[0],find[1]);
        intent.setComponent(name);
        intent.putExtra("package_name", mContext.getPackageName());
        intent.putExtra("package_label", R.string.app_name);
        return intent;
    }
}
