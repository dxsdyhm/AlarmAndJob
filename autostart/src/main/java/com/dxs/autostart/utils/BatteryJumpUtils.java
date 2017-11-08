package com.dxs.autostart.utils;

import android.content.Context;
import android.content.Intent;

import com.dxs.autostart.utils.data.BaseData;

/**
 * Created by USER on 2017/11/8.
 */

public class BatteryJumpUtils extends BaseJumpUtils {
    private String[] find=null;
    private static Context mContext;

    private static class BatteryJumpUtilsHolder{
        public static BatteryJumpUtils instance = new BatteryJumpUtils();
    }

    public static BatteryJumpUtils newInstance(Context context){
        mContext = context.getApplicationContext();
        return BatteryJumpUtilsHolder.instance;
    }

    private BatteryJumpUtils() {
    }

    @Override
    public boolean isTargetActivityFinded() {
        BaseData data=getPhoneData();
        if(data!=null){
            find=data.getUseBatterInfo(mContext);
        }
        return find!=null;
    }

    @Override
    public void toTargetActivity() throws Exception {
        Intent intent=getPhoneData().getBatterIntent(mContext);
        mContext.startActivity(intent);
    }
}
