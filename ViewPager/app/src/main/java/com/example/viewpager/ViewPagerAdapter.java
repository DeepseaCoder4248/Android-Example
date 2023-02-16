package com.example.viewpager;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewHolderPage> {

    ArrayList<DataPage> listData;

    // 데이터를 외부에서 지정 후 받아오는 생성자.
    public ViewPagerAdapter(ArrayList<DataPage> listData) {
        this.listData = listData;
    }

    @Override
    // View를 Return
    public ViewHolderPage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_viewpager, parent, false);
        return new ViewHolderPage(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPage holder, int position) {
        if (holder instanceof ViewHolderPage) {
            ViewHolderPage viewHolder = holder;
            viewHolder.onBind(listData.get(position)); // 아이템을 적용시키는 곳.
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
