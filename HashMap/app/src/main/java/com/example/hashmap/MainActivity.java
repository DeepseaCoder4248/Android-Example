package com.example.hashmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 해쉬맵: 방대한 데이터를 불러오고 저장하고 인텐트하기 위한 클래스.
        HashMap<String, String> student = new HashMap<String, String>(); // 해쉬맵 객체. <타입의 Key값, 타입의 Value값>을 작성한다. student는 학생의 정보다.
        Log.i("HashMap", String.valueOf(student));


        // 데이터
        student.put("First Name", "Inkwon"); // First Name은 String의 Key값, Inkwon은 String의 Value 값이다. 중복이 가능한지는 테스트 해봐야 알듯.
        student.put("Last Name", "kim"); // 데이터 삽입할 때 사용. Student.put 메소드를 불러온다.
        student.put("Skills", "HTML , CSS , JavaScript");
        student.put("Contury", "Korea");
        student.put("City", "Seoul");

        // 출력
        System.out.println(student.get("First Name")); // Value값인 InKwon 전시. Key값을 확인하고 싶을 때 사용. Student.get 메소드를 불러온다.
        System.out.println(student.get("Skills")); // Value값인 HTML~ 전시.
        System.out.println(student.get("City")); // Value값인 Seoul 전시.

        System.out.println(student.values()); // HTML , CSS , JavaScript, Inkwon, Korea, Seoul, kim 모두 전시. 데이터를 모두 확인할 때 사용. student.value 메소드 불러온다.

        if (student.containsKey("Skills")){ // 특정 키값이 있는지 확인. student.containskey 메소드 불러온다. 대략 EditText에서 검색하면 출력하는 구조인 듯.
            System.out.println("HashMap contains key is 'SKills'");
        }

        for(String Key: student.keySet()){ // Key라는 String 변수는 student의 Key값들 만큼 반복. student.KeySet 메소드 불러온다. For문에는 (int i = 0 i<10 i++)이 기본임.
            System.out.println(student.get(Key)); // Key 클래스는 위에 있는 String의 Key다.
        }

        List list = new ArrayList(); // Array는 동일한 타입의 배열, ArrayList는 다양한 타입의 배열이다. 쓰는방법도 조금씩 다르다.
        System.out.println(student); // Skills=HTML , CSS , JavaScript, First Name=Inkwon, Contury=Korea, City=Seoul, Last Name=kim로 전시.
    }
}