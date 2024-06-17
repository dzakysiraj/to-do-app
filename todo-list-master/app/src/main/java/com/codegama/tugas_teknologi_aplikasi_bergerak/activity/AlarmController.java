package com.dzakysiraj.tugas_teknologi_aplikasi_bergerak.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dzakysiraj.tugas_teknologi_aplikasi_bergerak.bottomSheetFragment.CreateTaskBottomSheetFragment;

import java.util.Calendar;

public class AlarmController extends AlarmActivity {

    private Context m_Context;
    private AlarmManager mgr;
    private static final long PERIOD = 1000 * 30;

    public AlarmController(Context context){

        m_Context = context;
        mgr = (AlarmManager)m_Context.getSystemService(Context.ALARM_SERVICE);

    }

    public void StartAlarm(){

        Intent i = new Intent(m_Context, OnAlarmReceiver.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY,8);

        PendingIntent pi=PendingIntent.getBroadcast(m_Context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT );
        mgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);

        Log.i("AlarmController", "StartAlarm");
    }

    public void StopAlarm(){
        Intent i = new Intent(m_Context, OnAlarmReceiver.class);
        PendingIntent pi=PendingIntent.getBroadcast(m_Context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        mgr.cancel(pi);

        Log.i("AlarmController", "StopAlarm");
    }

}
