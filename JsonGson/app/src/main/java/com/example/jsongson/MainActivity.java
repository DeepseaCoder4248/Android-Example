package com.example.jsongson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MainActivity extends AppCompatActivity {

    ItemData itemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemData = new ItemData("mike", 10);

        Gson gson = new Gson();

        String alpha = gson.toJson(itemData); // toJson은 Java-Json의 변환인데 Json으로 변환을 한다는게 String Type으로 바꾸는 것 같다

        Log.i("TAG", alpha); // Json 변환시 {"num":0}으로 변환됨.

        ItemData revItemData = gson.fromJson(alpha, ItemData.class);

        Log.i("TAG", revItemData.setData());

        if(false){
            Log.i("TAG","false");
        }else{
            Log.i("TAG","true");

        }
    }
}