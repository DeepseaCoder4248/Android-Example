package com.example.taling12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

// save버튼을 눌렀을대 edtText, edtText2값 읽어와서 String변수에 각각 저장

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    Button btnRead;
    EditText edtText;
    EditText edtText2;
    TextView tvResult;

    String getText;
    String getText2;

//    ArrayList<String> documents = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = findViewById(R.id.btn_read);
        btnSave = findViewById(R.id.btn_save);
        edtText = findViewById(R.id.edt_text);
        edtText2 = findViewById(R.id.edt_text2);
        tvResult = findViewById(R.id.tv_result);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getText = edtText.getText().toString();
                getText2 = edtText2.getText().toString();

                // SharedPreference에 값 저장하기
                // (키, 값) (키, 값) (키, 값) (키, 값)
                // 키 값이 중복되면 값을 덮어버림 (새로운 값으로)

                // SharedPreferece 오픈하면서 user 도큐먼트 생성
                SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
//                documents.add("user");
//                documents.add("security");

                // 값을 넣고
                // Create
                // Update
                SharedPreferences.Editor editor = preferences.edit();


                editor.putString("my_first", getText);
                editor.putString("my_second", getText2);

                // 마지막 넣은 것들 저장
                editor.commit();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);

                // 값을 읽어올때는 editor필요없음
                // defaultValue => 해당 키에대한 값이 없을때 기본 값

                String data1 = preferences.getString("my_first", "yes");
                String data2 = preferences.getString("my_second", "yes");

                ArrayList arrayList = new ArrayList();

                arrayList.add(data1);
                arrayList.add(data2);

                tvResult.setText("datas: " + arrayList.toString());

            }
        });
    }
}