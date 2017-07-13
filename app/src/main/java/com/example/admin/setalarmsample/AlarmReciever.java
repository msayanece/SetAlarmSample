package com.example.admin.setalarmsample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;

import static android.content.Context.VIBRATOR_SERVICE;

public class AlarmReciever extends BroadcastReceiver {
    private Ringtone ringtone;
    private Vibrator vibrator;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        // here you can start an activity or service depending on your need
        // for ex you can start an activity to vibrate phone or to ring the phone
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        ringtone = RingtoneManager.getRingtone(context, uri);
        ringtone.play();
        vibrator = ((Vibrator) context.getSystemService(VIBRATOR_SERVICE));
        long[] pattern = {100, 1440, 510};
        vibrator.vibrate(pattern,0);
//        Toast.makeText(context, "Alarm Triggered!", Toast.LENGTH_LONG).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ringtone.stop();
                vibrator.cancel();
            }
        }, 20000);
    }
}
