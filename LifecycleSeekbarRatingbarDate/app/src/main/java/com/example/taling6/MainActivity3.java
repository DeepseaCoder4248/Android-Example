package com.example.taling6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    // SeekBar (씨크바) 씩바

    TextView textView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView = findViewById(R.id.tv_content);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("CHECK", "현재값: " + progress);
                textView.setText(""+progress);
                textView.setTextSize(10 * progress);
//                seekBar.getMax();
//                Toast.makeText

                int max = seekBar.getMax();
                
                if(progress == max) {
                    Toast.makeText(MainActivity3.this, "최대입니다~", Toast.LENGTH_SHORT).show();
                }

                // getMax메소드를 부르면 현재 Seekbar의 최대값이 리턴된다.
//                seekBar.getMAx


                // 최대값에 도달하면 Toast메시지 출력 (최대입니다!!)
//                seekBar.getMax()

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}