package com.puresoftware.motioneventactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.view);

        view.setOnTouchListener(new View.OnTouchListener(){

            @Override

            public boolean onTouch(View v, MotionEvent event){

                int action = event.getAction(); // 상당히 많이 호출되는, 온터치 메소드의 구분자역할을 함.

                float curX = event.getX();

                float curY = event.getY();

                if(action==MotionEvent.ACTION_DOWN){

                    Log.i("TAG","손가락 눌렸음 : " + curX + "," + curY);



                }else if(action==MotionEvent.ACTION_MOVE){

                    Log.i("TAG","손가락 움직임 : "+curX+","+curY);



                }else if(action==MotionEvent.ACTION_UP){

                    Log.i("TAG","손가락 뗴졌음 : "+curX+","+curY);

                }

                return true;



            }

        });
    }
}