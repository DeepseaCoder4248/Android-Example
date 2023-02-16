package com.example.callbacklistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listener.onEvent();
    }

    MyEventListener listener = new MyEventListener() { // 인터페이스는 한번 호출하면 코드가 모두 전시. 그리고 변경이 불가능하다.
        @Override
        public void onEvent() {

        }
    };

//    MyEventClass listener2 = listener.onEvent(); 클래스 호출은 객체를 따로 불러올 수 있다.

//    MyEventClass listener3 = new MyEventClass().onEvent2(); 클래스 호출은 객체를 따로 불러올 수 있다.


}