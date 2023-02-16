package com.example.broadcastpassive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);
        TextView tvValue = findViewById(R.id.tv_value);

        // menifest에 들어가던 내용을 생각하면 쉽다.
        MyReceiver myReceiver = new MyReceiver(); // 리시버 객체
        IntentFilter filter = new IntentFilter(); // <intent-filter>
        filter.addAction("com.gugu.nice"); // android:name="com.gugu.nice"
        registerReceiver(myReceiver, filter); // 리시버 등록

        // ex. 다른곳으로 보내고 싶은 경우?
        SubActivity.MyReceiver myReceiver2 = new SubActivity.MyReceiver();
        registerReceiver(myReceiver2,filter);

        // 동작버튼
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Intent는 동일하게.
                Intent intent = new Intent();
                intent.setAction("com.gugu.nice");
                // setPackage는 필요 없음.
                sendBroadcast(intent);
            }
        });
    }
}