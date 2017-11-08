package com.dxs.autostart.utils;

import android.os.Build;

import com.dxs.autostart.utils.data.BaseData;
import com.dxs.autostart.utils.data.HuaWeiData;
import com.dxs.autostart.utils.data.LeTVData;
import com.dxs.autostart.utils.data.MeizuData;
import com.dxs.autostart.utils.data.OPPOData;
import com.dxs.autostart.utils.data.XiaoMiData;

/**
 * Created by USER on 2017/11/8.
 */

public abstract class BaseJumpUtils {
    public static final String XIAOMI="XIAOMI";//小米
    public static final String HUAWEI="HUAWEI";//华为
    public static final String Letv="Letv";//乐视
    public static final String samsung="samsung";//三星
    public static final String vivo="vivo";//vivo
    public static final String Meizu="Meizu";//魅族
    public static final String OPPO="OPPO";//oppo
    public static final String ulong="ulong";//360

    public String getMobileType() {
        return Build.MANUFACTURER;
    }

    public boolean isTargetPhone(String target){
        return getMobileType().equalsIgnoreCase(target);
    }

    public abstract boolean isTargetActivityFinded();
    public abstract void toTargetActivity() throws Exception;

    public BaseData getPhoneData(){
        if(isTargetPhone(XIAOMI)){
            return new XiaoMiData();
        }else if(isTargetPhone(HUAWEI)){
            return new HuaWeiData();
        }else if(isTargetPhone(Letv)){
            return new LeTVData();
        }else if(isTargetPhone(Meizu)){
            return new MeizuData();
        }else if(isTargetPhone(OPPO)){
            return new OPPOData();
        }
        return null;
    }
}
