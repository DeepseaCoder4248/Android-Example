package com.example.modulesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnAdd;
    ListAdapter adapter;

    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.v_listView);
        btnAdd = findViewById(R.id.btn_add);

        adapter = new ListAdapter();
        listView.setAdapter(adapter);

        ItemData data1 = new ItemData("데이터 가공");
        ItemData data2 = new ItemData("샘플2");
        ItemData data3 = new ItemData("샘플3");
        ItemData data4 = new ItemData("샘플4");

        adapter.addItem(data1);
        adapter.addItem(data2);
        adapter.addItem(data3);
        adapter.addItem(data4);

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count = count++;
//                ItemData itemData = new ItemData(count + "");
//
//            }
//        });

    }
}