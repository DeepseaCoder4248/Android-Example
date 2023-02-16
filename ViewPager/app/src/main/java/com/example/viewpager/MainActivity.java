package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2;
        Button btnToggle;

        viewPager2 = findViewById(R.id.viewPager2);
        btnToggle = findViewById(R.id.btnToggle);

        ArrayList<DataPage> list = new ArrayList<>();
        list.add(new DataPage(android.R.color.black, "1 Page"));
        list.add(new DataPage(android.R.color.holo_red_light, "2 Page"));
        list.add(new DataPage(android.R.color.holo_green_dark, "3 Page"));
        list.add(new DataPage(android.R.color.holo_orange_dark, "4 Page"));
        list.add(new DataPage(android.R.color.holo_blue_light, "5 Page"));
        list.add(new DataPage(android.R.color.holo_blue_bright, "6 Page"));

        viewPager2.setAdapter(new ViewPagerAdapter(list));
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (viewPager2.getOrientation() == ViewPager2.ORIENTATION_VERTICAL) {
//                    btnToggle.setText("가로로 슬라이드");
//                    viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
//                } else {
//                    btnToggle.setText("세로로 슬라이드");
//                    viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
//                }

                viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
            }
        });

    }
}