package service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import utils.ShowNotification;
import utils.pakageUtils;

/**
 * Created by USER on 2017/10/31.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ToastJobService extends JobService {
    private static final String TAG="ToastJobService";
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand:"+flags+"startId:"+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.e(TAG,"onStartJob:"+getShowTime());
        ShowNotification.show(this);
        Toast.makeText(this,"Job时间:"+getShowTime(),Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.e(TAG,"onStopJob:");
        return true;
    }

    private String getShowTime(){
        DateFormat sf= SimpleDateFormat.getDateTimeInstance();
        Date date = new Date();//创建时间
        String format = sf.format(date);//格式化 bf.format(date);
        return format;
    }
}
