package com.puresoftware.coordinatorlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<String> arrayList;

    public Adapter() {
        arrayList = new ArrayList<>();
    }

    // ListView Adapter의 View 생성 역할
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(context, view);
        return viewHolder;
    }

    // ListView Adapter의 data 주입 역할
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = arrayList.get(position);
        holder.textView.setText(text);
    }

    // ListView Adapter의 count 역할
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // ListView Adapter에서 만드는 MainActivity에서 Data를 가져오는 메소드 생성
    public void setArrayData(String strData) {
        arrayList.add(strData);
    }
}
