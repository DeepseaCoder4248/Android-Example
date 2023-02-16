package com.example.modulesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

// 이메일 (이메일형식맞지않습니다)
// sadlksajkdljaslkd

public class SampleActivity extends AppCompatActivity {

    EditText edtText;
    Button btnOk;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        edtText = findViewById(R.id.edt_text);
        btnOk = findViewById(R.id.btn_ok);
        text = findViewById(R.id.tv_text);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = edtText.getText().toString();
                getText = getText.trim();

                Log.i("TAG", "getText: " + getText);

                String pattern = "\\w+@\\w+\\.\\w+(\\.\\w+)?"; // 식

                // 양옆의 공백을 지워주는 메소드
                // "gugu@gmail.com       "
                boolean regex = Pattern.matches(pattern, getText);
                System.out.println(regex);
                Toast.makeText(SampleActivity.this, regex + "", Toast.LENGTH_SHORT).show();

                String[] splitText = getText.split("@");
                String beforeText = splitText[0];
                String afterText = splitText[1];
                Toast.makeText(SampleActivity.this, beforeText + ", " + afterText, Toast.LENGTH_SHORT).show();

                String result = "첫번째값: " + beforeText + ", 두번째값: " + afterText;
                text.setText(result);

//                if (getText.length() > 5) {
//                    if (getText.contains("@") && getText.contains(".com") || getText.contains(".net")) {
//                        Toast.makeText(SampleActivity.this, "확인", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(SampleActivity.this, "사용불가", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(SampleActivity.this, "길이가 맞지 않습니다", Toast.LENGTH_SHORT).show();
//                }
            }
        });


    }
}