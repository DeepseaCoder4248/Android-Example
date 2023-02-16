package com.example.samplerecylerview;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PersonAdaper extends RecyclerView.Adapter<PersonAdaper.ViewHolder> {

    ArrayList<Person> items = new ArrayList<Person>(); // 2.addItem()에서 받은 item을 넣음.
    Context context;
    LayoutInflater layoutInflater;
    View itemView;

    @NonNull
    @Override
    // 3.ViewHolder 상속 후 메소드 불러오기.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext()); // ?
        itemView = layoutInflater.inflate(R.layout.person_item, parent, false);
        return new ViewHolder(itemView); // view를 홀딩한다? 여튼 Gropup으로 Return 하는 듯.

    }

    @Override // 4.items에서 받은 내용을 지정하기.
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // position은 어디 시스템 내부에서 가져온다.
        Person item = items.get(position); // position을 가져오면 ArrayList에서 그 Position에 맞는 값을 가져오고 Person 클래스에 저장한다.
        holder.setItem(item);

    }

    @Override // ArrayList에서 Item의 갯수
    public int getItemCount() {
        return items.size();
    }

    // 5.ViewHolder 기능만 실행하게 하는 중첩 클래스로 추정.
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        // Person 클래스의 데이터로 등록하면 textView에 Item을 등록하는 듯. setAdapter임.
        public void setItem(Person item) {
            textView = itemView.findViewById(R.id.tv_name);
            textView2 = itemView.findViewById(R.id.tv_mobile);
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    // 1.실제로 메인에서 Item 추가.
    public void addItem(Person item) {
        items.add(item);
    }

    public void setItems(ArrayList<Person> items) {
        this.items = items;
    }

    public void setItem(int position, Person item) {
        items.set(position, item);
    }
}
