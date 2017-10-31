package service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by USER on 2017/10/31.
 */

public class TostService extends Service {
    private final static String TAG="TostService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
        Log.e(TAG,"onCreate"+getShowTime());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"时间:"+getShowTime(),Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy"+getShowTime());
    }

    private String getShowTime(){
        DateFormat sf= SimpleDateFormat.getDateTimeInstance();
        Date date = new Date();//创建时间
        String format = sf.format(date);//格式化 bf.format(date);
        Log.e(TAG,"format:"+format);
        return format;
    }
}
