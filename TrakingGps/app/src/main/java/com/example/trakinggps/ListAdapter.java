package com.example.trakinggps;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    ArrayList<ItemData>datas = new ArrayList<>();

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            Context context = parent.getContext(); // ?
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item,parent,false);
        }

        TextView tvLocation = convertView.findViewById(R.id.tv_location);
        TextView tvGpsLog = convertView.findViewById(R.id.tv_gpsLog);

        final ItemData itemData = datas.get(position);
        String getLocation = itemData.location;
        String getGpsLog = itemData.log;

        tvLocation.setText(getLocation);
        tvGpsLog.setText(getGpsLog);

        return convertView;
    }

    public void addItem (ItemData itemData){
        datas.add(itemData);
    }
}
