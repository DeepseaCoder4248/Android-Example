package com.example.broadcastactive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.gugu.nice");
                intent.setPackage("com.example.broadcastactive");
                sendBroadcast(intent);
            }
        });

    }
}


// 1. files-new-other-broadcastReciver
// 2. menifest에서 receiver 항목이 잘 들어와있는지 확인

// 3.             <intent-filter>
//                <action android:name="com.gugu.nice" />
//            </intent-filter>
//        </receiver>

// 4.

