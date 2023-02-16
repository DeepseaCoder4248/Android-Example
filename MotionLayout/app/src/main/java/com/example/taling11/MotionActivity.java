package com.example.taling11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class MotionActivity extends AppCompatActivity {

    //    private var selectedIndex: Int = 0;
    int selectedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        final MotionLayout ml = findViewById(R.id.motion_container);

        View v1 = findViewById(R.id.v1);
        View v2 = findViewById(R.id.v2);
        View v3 = findViewById(R.id.v3);

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex == 0) return;

                ml.setTransition(R.id.s2, R.id.s1);
                ml.transitionToEnd();
                selectedIndex = 0;
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex == 1) return;

                if (selectedIndex == 2) {
                    ml.setTransition(R.id.s3, R.id.s2);
                } else {
                    ml.setTransition(R.id.s1, R.id.s2);

                }
                ml.transitionToEnd();
                selectedIndex = 1;
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex == 2) return;

                ml.setTransition(R.id.s2, R.id.s3);
                ml.transitionToEnd();
                selectedIndex = 2;
            }
        });
    }
}