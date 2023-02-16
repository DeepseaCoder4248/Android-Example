package com.example.taling6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

// 안드로이드 생명주기 (액티비티 생명주기)
// 없어도 앱은 만들수있음
// 제대로된 앱(최적화, 기능분리)을 만들기위해서는 필수
// 액티비티 생명주기 개념이 없는 앱은 99.9999999999999% 없다.

// 로그캣(디버깅, 어디서틀렸고)

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        System.out.println("나는 onCreate입니다");
        Log.i("MY_LOG", "나는 onCreate입니다");
    }

    // 이클립스 (알트 쉬프트 s)
    // 안드로이드 스튜디오 (컨트롤 o)

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("My_LOG", "나는 onStart");

        // 로그

        //daskldjaskld오류 오류코드

        //로그
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("My_LOG", "나는 onResume입니다");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("My_LOG", "나는 onPause입니다");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("My_LOG", "나는 onStop입니다");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("My_LOG","나는 onDestroy입니다");
    }
}