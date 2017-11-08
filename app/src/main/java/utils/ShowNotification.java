package utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.user.alarmandjob.MyApp;
import com.example.user.alarmandjob.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by USER on 2017/11/7.
 */

public class ShowNotification {

    public static void show(Context mContext){
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.mipmap.ic_launcher;
        String ticker = "您有一条新通知";
        String title = "自启动测试";
        String content = "时间："+getShowTime();
        NotifiUtils notify1 = new NotifiUtils(mContext, 1);
        notify1.notify_normal_singline(pIntent, smallIcon, ticker, title, content, true, true, true);
    }

    private static String getShowTime(){
        DateFormat sf= SimpleDateFormat.getDateTimeInstance();
        Date date = new Date();//创建时间
        String format = sf.format(date);//格式化 bf.format(date);
        return format;
    }
}
