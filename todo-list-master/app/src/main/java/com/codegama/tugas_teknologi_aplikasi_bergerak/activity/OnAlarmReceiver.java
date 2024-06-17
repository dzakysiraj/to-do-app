package com.dzakysiraj.tugas_teknologi_aplikasi_bergerak.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dzakysiraj.tugas_teknologi_aplikasi_bergerak.bottomSheetFragment.CreateTaskBottomSheetFragment;

public class OnAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, CreateTaskBottomSheetFragment.class));
    }
}
