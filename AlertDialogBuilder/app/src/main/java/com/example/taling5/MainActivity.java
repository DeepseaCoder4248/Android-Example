package com.example.taling5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    EditText edtValue;
    TextView tvResult;
    Button btnOk;
    ImageView ivResultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_resultText);
        edtValue = findViewById(R.id.edt_value);
        btnOk = findViewById(R.id.btn_ok);
        ivResultImage = findViewById(R.id.iv_resultImage);

        Random random = new Random(); //?

        final int randomNum = random.nextInt(100) + 1;


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 자바 String int 변환

                String s = edtValue.getText().toString();
                int getValue = Integer.parseInt(s);
//                String result;

                if (getValue == randomNum) {
//                    String result = Integer
                    tvResult.setText("정답입니다");
                    ivResultImage.setImageResource(R.drawable.smile);

                    // this 가 안된다
                    // getApplicationContext();
                    show();


                } else if (getValue > randomNum) {
                    tvResult.setText("높습니다");
                    ivResultImage.setImageResource(R.drawable.angry);
                } else {
                    tvResult.setText("낮습니다");
                    ivResultImage.setImageResource(R.drawable.sad);
                }


            }
        });
    }

    private void show() {
        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결과");
        builder.setMessage("축하축하");
        builder.setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "확인했습니다.", Toast.LENGTH_LONG).show();


                    }
                });
        builder.show();
    }
}