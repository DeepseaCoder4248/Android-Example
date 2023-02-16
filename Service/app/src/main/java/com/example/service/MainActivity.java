package com.example.service;

import android.content.Intent;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.service.R.raw.chacha;
import static com.example.service.R.raw.sound;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    int clickNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, sound); // raw 리소스 폳러를 만든 다음, 포맷 형식의 파일 불러오기.

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 서비스 시작하기
                Log.d("test", "액티비티-서비스 시작버튼클릭");


                Intent intent = new Intent(
                        getApplicationContext(),//현재제어권자
                        MyService.class); // 이동할 컴포넌트
                startService(intent); // 서비스 시작
            }
        });
        // 서비스 모드는 액티비티가 종료되면 실행 종료입니다. 뭔가 이상한데? 코드 수정이 필요할 듯.

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 서비스 종료하기
                Log.d("test", "액티비티-서비스 종료버튼클릭");
                Intent intent = new Intent(
                        getApplicationContext(),//현재제어권자
                        MyService.class); // 이동할 컴포넌트
                stopService(intent); // 서비스 종료
            }
        });
        // 서비스 모드를 종료하기 위해서는 눌러야 합니다.

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickNum == 0) {
                    mp.start(); // 노래 시작
                    Log.i("test", mp + "");
                    mp.setLooping(true); // 반복재생
                    clickNum = clickNum + 1;
                    Log.d("test", clickNum + "");
                    return;
                }
            }
        });
        // 일반 모드는 액티비티가 종료되면 실행 종료입니다 그리고 풀로 재생합니다.
    }
}

