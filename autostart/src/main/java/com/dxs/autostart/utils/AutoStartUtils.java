package com.dxs.autostart.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dxs.autostart.utils.data.BaseData;


/**
 * Created by USER on 2017/11/8.
 */

public class AutoStartUtils extends BaseJumpUtils {
    private String[] find=null;
    private static Context mContext;

    private static class AutoStartUtilsHolder{
        public static AutoStartUtils instance = new AutoStartUtils();
    }

    public static AutoStartUtils newInstance(Context context){
        mContext = context.getApplicationContext();
        return AutoStartUtilsHolder.instance;
    }

    private AutoStartUtils() {
    }

    @Override
    public boolean isTargetActivityFinded() {
        BaseData data=getPhoneData();
        Log.e("dxsTest","data:"+data.getClass());
        if(data!=null){
            find=data.getUseAutoStartInfo(mContext);
        }
        return find!=null;
    }

    @Override
    public void toTargetActivity() throws Exception {
        Intent intent=getPhoneData().getAuttoStartIntent(mContext);
        mContext.startActivity(intent);
    }
}
