package com.example.taling6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

// 별점 (RatingBar)

// ReservationActivity

public class MainActivity4 extends AppCompatActivity {

    RatingBar ratingBar;
    TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_content = findViewById(R.id.tv_content);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setNumStars(5);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("CHECK",""+rating);
                tv_content.setText(""+rating);
            }
        });

    }
}