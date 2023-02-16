package com.example.taling7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

// 자바 기본
// 컴퓨터공학의 자료구조
// 배열
// List, Map
// 나열 (배열)~~a,b,c,d,e,d
// Map (매핑한다~) a -> 1,  b -> 2

// 배열, 리스트, Map -> 서버
// TTS (Text to Speech) 글자를 말로 바꾸는 기능

public class MainActivity extends AppCompatActivity {

    EditText edt_input;
    Button btn_Start;
    TextToSpeech speech;
    SeekBar ttsTone;
    SeekBar ttsSpeed;

    static final String MY_TAG = "MY_TTS_LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_input = findViewById(R.id.edt_input);
        btn_Start = findViewById(R.id.btn_run);
        ttsTone = findViewById(R.id.ttsTone);
        ttsSpeed = findViewById(R.id.ttsSpeed);

        ttsTone.setMax(5);
        ttsSpeed.setMax(5);

//        int cur = seekBar.getProgress();

        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // TextToSpeech객체 만들때 초기화작업하는 작업

                Log.i(MY_TAG, "onInit성공");
            }
        });



        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getText = edt_input.getText().toString();
                int toneValue = ttsTone.getProgress();
                int speedValue = ttsSpeed.getProgress();
                Log.i(MY_TAG, "tone: " + toneValue);
                Log.i(MY_TAG, "speed: " + speedValue);

                speak(getText, toneValue, speedValue);
            }
        });

        // 가져오는 시점
        // 1) 값이 변화되었을때 (setOn~~~)
        // 2) 클릭했을때

        // 정수 < 소수 (범위)
        // 1.34 = 1
        // 1 = 1.0

        // 정수 -> 소수로
//        double b = 1;
//        Log.i("hihihihi", "" + b);
//
//        float a = 1;
//        Log.i("hihihihi", ""+a);

    }

    public void speak(String changeTTS, float ton, float speed) {
//        ~~~~ 텍스트를 음성으로 출ㄹ력
//        TTS (안드로이드 버전) LOLLIPOP 기준으로 나뉨
//        1) 현재 실행된 스마트폰버전이 몇인지 구별하는 방법;
//        2) 구별하여 코드 실행
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            speech.setLanguage(Locale.KOREA);
            speech.setPitch(ton);
            speech.setSpeechRate(speed);
            speech.speak(changeTTS, TextToSpeech.QUEUE_ADD, null, "111");
        } else {

        }
    }

//    public void changeSeekbar() {
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // 바뀌었을 때
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int cur, boolean fromUser) {
//                cur =
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//    }


}