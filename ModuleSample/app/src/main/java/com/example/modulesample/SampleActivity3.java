package com.example.modulesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

// 버튼눌러ㅆ을때, edittext의 문자열을 가져와 변수에 저장
// 매개변수로 문자열을 받고, 문자열의 길이를 리턴하는 메소드 만들기

// 가나다라 의 문자열길이 4

// 가나다라의 길이는 4 입니다.

// korea japan usa
// 메소드에 던지면 일본 만 추출해서 리턴

public class SampleActivity3 extends AppCompatActivity {

    TextView tvContent;
    EditText edtContent;
    Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample3);

        tvContent = findViewById(R.id.tvContent);
        edtContent = findViewById(R.id.edtContent);
        btnProcess = findViewById(R.id.btnProcess);

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = edtContent.getText().toString();

                if (content == "") {
                    Toast.makeText(SampleActivity3.this, "내용을 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
//                    int length = getLength(content);
//                    tvContent.setText(content + "의 길이는 " + length + "입니다.");

//                String parseContent = getJapan(content);
//                tvContent.setText(parseContent);

                    Dog dog = new Dog();
                    dog.speak();

                    // 추상클래스는 객체로 바로 만들수없다
                    Human human = new Human();
                    human.eat();
//                    Monkey monkey = new Monkey() {
//                        @Override
//                        public void eat() {
//                            System.out.println("먹는다");
//                        }
//                    };
//
//                    monkey.eat();
                }
            }
        });
        //
    }


//    Monkey monkey = new Monkey() {
//        // 컨트롤 + O
//
//        @Override
//        public void eat() {
//            System.out.println("바나나 먹는다");
//        }
//    };


    public int getLength(String content) {
        int length = content.length();
        return length;
    }

    public String getJapan(String content) {
//        int start = content.indexOf("japan");
//
//        int end = content.indexOf("usa");
//
//        // korea japan usa
//        // 0: k
//        // 12: u
//        // 14
//
//        // 6~12
//        // 0이상 12미만까지
//        Log.i("TAG", ""+start);
//        Log.i("TAG", ""+end);
//        String parseText = content.substring(start, end);
//        return parseText;

        // 문자열을 특정 문자 기준으로 자르는 방법

//        content에서 japan뽑아봐!

        String[] contents = content.split(" ");
        return contents[1];
    }
}