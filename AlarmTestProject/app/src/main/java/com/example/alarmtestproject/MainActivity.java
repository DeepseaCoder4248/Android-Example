package com.example.alarmtestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtHour;
    EditText edtMinute;
    EditText edtSeconds;
    Button btnStart;

    EditText edtBroadCast;
    Button btnStart2;

    static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHour = findViewById(R.id.edt_hour);
        edtMinute = findViewById(R.id.edt_minute);
        edtSeconds = findViewById(R.id.edt_seconds);
        btnStart = findViewById(R.id.btn_start);

        edtBroadCast = findViewById(R.id.edt_broadcast);
        btnStart2 = findViewById(R.id.btn_start2);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                assert !edtHour.getText().toString().equals("");
//                assert !edtMinute.getText().toString().equals("");
//                assert !edtSeconds.getText().toString().equals("");

                if (edtHour.getText().toString().equals("") || edtMinute.getText().toString().equals("") || edtSeconds.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "입력정보가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    int hour = Integer.parseInt(edtHour.getText().toString());
                    int minute = Integer.parseInt(edtMinute.getText().toString());
                    int seconds = Integer.parseInt(edtSeconds.getText().toString());

                    Log.i(TAG, "hour:" + hour + " minute:" + minute + " seconds:" + seconds);

                    // Intent, PendingIntent, AlarmManager
                    Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);

                    String data = edtBroadCast.getText().toString();

                    intent.putExtra("content", data);
                    intent.setAction("com.gugu.test");

                    PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

                    // 기본 브로드캐스트리시버 방법 1
                    // 알람매니저에서 자체적으로 브로드캐스트리시버 방법 2
                    AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

                    // 안드로이드 버전에 따라서 동작방식이 다르다
                    // 23이전과 이후로 (나눠야함)
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                        // API 23 이전
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            // 19이상일때
//                            manager.setExact;                       19~23이전, 23이상
//                            manager.set;                            19미만 
//                            manager.setRepeating;                   19~23이전, 23이상
//                            manager.setInexactRepeating();          19~23이전
//                            manager.setExactAndAllowWhileIdle();    23이상

//                            manager.setExact(시간종류, 시작시간, PendingIntent);
                            // UTC 전세계 시간 : RTC
                            // 부팅이후의 시간  : ELAPSED_REALTIME
                            // WAKE_UP : 절전모드에서 깨운다

//                            10초이후의 시간을 long으로 구하기
//                            현재시간을 받아옴 : 101212454 + 10초



                        } else {
                            // 19미만일때
                        }
                    } else {
                        // API 23이후
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.HOUR_OF_DAY,hour);
                        cal.set(Calendar.MINUTE,minute);
                        cal.set(Calendar.SECOND,seconds);

                        long after = cal.getTimeInMillis();

                        Log.i(TAG, "after: " + after);

                        manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, after, sender);
                    }
                }
            }
        });

        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 최초의 서비스 실행
                // 10초뒤에
                Calendar cal = Calendar.getInstance();
                long time = (cal.getTimeInMillis()+(1000 * 10));

                // Intent, PendingIntent, AlarmManager
                Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);

                intent.setAction("com.gugu.register_service");

                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
                AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    // API 23 이전
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                    } else {

                    }
                } else {

                    manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, sender);
                }
            }
        });


    }

}