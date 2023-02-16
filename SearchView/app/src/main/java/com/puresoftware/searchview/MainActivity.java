package com.puresoftware.searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = findViewById(R.id.rv_view);
        view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        UserInfo info1 = new UserInfo("김발", "17", 2451);
        UserInfo info2 = new UserInfo("Raychell", "23", 6792);
        UserInfo info3 = new UserInfo("@%!S!@", "#$^#^#^", 1110);
        UserInfo info4 = new UserInfo("김구땅", "12", 1151);
        UserInfo info5 = new UserInfo("Trisha", "25", 6674);


        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
//        adapter.getData(info1);
//        adapter.getData(info2);
//        adapter.getData(info3);
        adapter.getData(info4);
        adapter.getData(info5);
        view.setAdapter(adapter);
    }
}