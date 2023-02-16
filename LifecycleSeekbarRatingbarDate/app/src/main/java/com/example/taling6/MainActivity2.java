package com.example.taling6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tvview;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvview = findViewById(R.id.tv_content);
        calendarView = findViewById(R.id.calendarView);

        // 자바, 파이썬, C, 루비, 모든언어에서는 월 0부터 시작
        // 2020년 9월 4일

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.i("CHECK", "날짜가 선택되었습니다");
                Log.i("CHECK", year + "" + (month + 1) + "" + dayOfMonth);

                tvview.setText(year + "년 " + month + "월 " + dayOfMonth + "일 ");
            }
        });


    }

}