package com.example.alarmtestproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.util.Calendar;

public class MyService extends Service {

    static final String TAG = MyService.class.getSimpleName();

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 백그라운드로 실행할 코드를 작성
        
        // sharedpreference에서 알람일정 가져옴
        // 하루마다 등록하는 로직

        testAlarm();
        resetService();

        return START_STICKY;
    }
    
    // 하루마다 등록하는 메소드
    public void resetService() {
        Calendar cal = Calendar.getInstance();
        long time = (cal.getTimeInMillis() + (1000 * 60));

        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);

        // 서비스 등록하라는 알람이 발생되면 액션명은 아래와 같음
        intent.setAction("com.gugu.register_service");
        PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // API 23 이전
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            } else {
            }
        } else {
            // API 23이후
            // shared에서 시,분,초

            Log.i(TAG, "time: " + time);

            manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, sender);
        }

    }


    public void testAlarm(){
        // Intent, PendingIntent, AlarmManager
        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        
        // 알람이 발생되는 액션명은 아래와 같음
        intent.setAction("com.gugu.alarm_message");
        intent.putExtra("title", "유튜브볼시간");
        intent.putExtra("content", "페이커");

        Log.i("gugu", "1");

        PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // 안드로이드 버전에 따라서 동작방식이 다르다
        // 23이전과 이후로 (나눠야함)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // API 23 이전
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            } else {
            }
        } else {
            // API 23이후
            // shared에서 시,분,초
            
            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.HOUR_OF_DAY,hour);
//            cal.set(Calendar.MINUTE,minute);
//            cal.set(Calendar.SECOND,seconds);

            long after = (cal.getTimeInMillis() +(1000 * 30));

            Log.i(TAG, "after: " + after);

            manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, after, sender);
        }

    }
}