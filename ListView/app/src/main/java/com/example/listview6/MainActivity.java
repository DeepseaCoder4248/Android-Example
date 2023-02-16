package com.example.listview6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView m_oListView = null; // 리스트 뷰
    ImageButton btnAdd;
    int count = 9;

    TextView tvOfficialBoard; // 공지사항 게시판
    TextView tvFreeBoard; // 자유 게시판
    TextView tvEventBoard; // 이벤트 게시판
    ImageView tvImgageBoard; // 각 게시판의 이미지.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOfficialBoard = findViewById(R.id.tv_officialBoard);
        tvFreeBoard = findViewById(R.id.tv_freeBoard);
        tvEventBoard = findViewById(R.id.tv_eventBoard);
        tvImgageBoard = findViewById(R.id.img_boardImage);
        btnAdd = findViewById(R.id.btn_write);

        // ListView, Adapter 생성 및 연결
        m_oListView = findViewById(R.id.listView); // 연동을 해야 사용이 가능하겠지?

        // 어댑터 객체 생성
        // 맨 처음에 실행되는 메소드 O
        // 맨 처음에있는 메소드가 실행되는 것 X
        final ListAdapter adapter = new ListAdapter();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // i =0   1보다
                ItemData data = new ItemData();
                data.strTitle = "내용"+ count;
                data.strDate = "2020.1.1";
                adapter.addItem(data);
                m_oListView.setAdapter(adapter);
                count++;
            }
        });

        // 데이터를 뿌려주기
        ItemData data1 = new ItemData();
        data1.strDate = "2020-12-12";
        data1.strTitle = "크리스마스 온다~~";

        ItemData data2 = new ItemData();
        data2.strTitle = "어린이 날";
        data2.strDate = "2020.5.5";

        ItemData data3 = new ItemData();
        data3.strTitle = "3일 절";
        data3.strDate = "2020.3.1";

        ItemData data4 = new ItemData();
        data4.strTitle = "오아와오아";
        data4.strDate = "2020.6.12";

        ItemData data5 = new ItemData();
        data5.strTitle = "호하호하";
        data5.strDate = "2020.2.21";

        adapter.addItem(data1);
        adapter.addItem(data2);
        adapter.addItem(data3);
        adapter.addItem(data4);
        adapter.addItem(data5);


        // 어댑터
        m_oListView.setAdapter(adapter);
    }
}