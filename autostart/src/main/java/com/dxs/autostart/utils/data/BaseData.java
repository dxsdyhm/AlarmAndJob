package com.dxs.autostart.utils.data;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

import java.util.HashMap;

/**
 * Created by USER on 2017/11/8.
 */

public abstract class BaseData {
    public static final String SPLITE="##";

    public abstract HashMap<String,String> getBatterInfo();
    public abstract HashMap<String,String> getAutoStarInfo();

    public Intent getBatterIntent(Context mContext){
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String[] find=getUseBatterInfo(mContext);
        ComponentName componentName =new ComponentName(find[0],find[1]);
        intent.setComponent(componentName);
        return intent;
    }
    public Intent getAuttoStartIntent(Context mContext){
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String[] find=getUseAutoStartInfo(mContext);
        ComponentName componentName =new ComponentName(find[0],find[1]);
        intent.setComponent(componentName);
        return intent;
    }
    public String[] getUseBatterInfo(Context mContext){
        if(mContext==null){
            return null;
        }
        HashMap<String,String> map=getBatterInfo();
        return checkActivity(mContext,map);
    }

    public String[] getUseAutoStartInfo(Context mContext){
        if(mContext==null){
            return null;
        }
        HashMap<String,String> map=getAutoStarInfo();
        return checkActivity(mContext,map);
    }

    private String[] checkActivity(Context mContext,HashMap<String,String> map){
        for (String pakageAndName:map.values()) {
            String[] temp=pakageAndName.split(SPLITE);
            Intent intent = new Intent();
            ComponentName componentName =new ComponentName(temp[0],temp[1]);
            intent.setComponent(componentName);
            ActivityInfo activityInfo = intent.resolveActivityInfo(mContext.getPackageManager(), intent.getFlags());
            if(activityInfo!=null&&activityInfo.exported){
                return temp;
            }
        }
        return null;
    }

    /**
     * 拼接包名与页面
     * @param pakageAndName pakage and name
     * @return pakage##name
     */
    public String getSpliteName(String[] pakageAndName){
        return pakageAndName[0]+SPLITE+pakageAndName[1];
    }
}
