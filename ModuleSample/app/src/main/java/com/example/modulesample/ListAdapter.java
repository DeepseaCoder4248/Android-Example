package com.example.modulesample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ItemData> datas = new ArrayList<>();
    Intent intent;

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) { // 아이템의 포지션
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // 레이아웃 인플레이팅
            context = parent.getContext(); // Context를 생성하면 getSystemService 호출이 가능하다. 무언가 얻어오는 Context는 반드시 getContext를 하기.

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // Inflater 권한을 가져온다.

            // 인플레이팅해서 반환받은 convertView가 있어서 레이아웃 요소에 접근이 가능하다
            convertView = inflater.inflate(R.layout.listview_item, parent, false); // converterView(View), Fragment나 infalter에서 다른 Activity에 쓰려면 View.findViewById는 필수다.
        }

        Button btnItem = convertView.findViewById(R.id.btn_item);
        ItemData data = datas.get(position);

        String value = data.getNumber();

        btnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (value.equals("데이터 가공")) {
                    intent = new Intent(context, SampleActivity.class);
                } else if (value.equals("샘플2")) {
                    intent = new Intent(context, SampleActivity2.class);
                } else if(value.equals("샘플3")) {
                    intent = new Intent(context, SampleActivity3.class);
                }
                context.startActivity(intent);
            }
        });

        btnItem.setText(value);

        return convertView;
    }

    public void addItem(ItemData item) {
        datas.add(item);
    }
}
