package com.example.samplerecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView); // RecyclerView
        ImageView imageView = findViewById(R.id.imageView);
        EditText edtName = findViewById(R.id.edt_name); // 이름 입력
        EditText edtMobile = findViewById(R.id.edt_mobile); // 전화번호 입력
        Button btnAdd = findViewById(R.id.btn_add); // 추가 버튼

        // Adapter 설정
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false); // RecyclerView의 LinearLayout
//        recyclerView.setLayoutManager(layoutManager); // 레이아웃 설정

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2); // RecyclerView의 Gridlayout
        recyclerView.setLayoutManager(layoutManager);

        PersonAdaper adapter = new PersonAdaper(); // 어댑터 생성

        // 버튼을 누르면 내용이 추가되어서 Item이 추가됨.
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = edtName.getText().toString();
                String getMobile = edtMobile.getText().toString();

                // 이름과 전화번호가 Null이 아니면 Adapter 실행. 실행이 되면 반복문 개념으로 초기화되어서 추가된다.
                if (!getName.toString().equals("") && !getMobile.toString().equals("")) {
                    Person person = new Person(getName, getMobile); // 매개변수식으로 넣는다.
                    adapter.addItem(person); // ListView와 같다.
                    recyclerView.setAdapter(adapter); // ListView와 같다.
                }
            }
        });

//        // 예시
//        Person person = new Person("김똥깨", "010-1234-5679");
//        Person person2 = new Person("시발놈", "010-2941-1030");
//
//        adapter.addItem(person);
//        adapter.addItem(person2);
//        recyclerView.setAdapter(adapter);
    }
}