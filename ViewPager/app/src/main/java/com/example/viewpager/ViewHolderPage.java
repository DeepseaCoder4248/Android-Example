package com.example.viewpager;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderPage extends RecyclerView.ViewHolder {

    private TextView tv_title;
    private RelativeLayout rl_layout;

    DataPage data;

    // viewHolderPage는 간단하게 말해서, Adapter에 사용할 View 코드를 리소스 향상을 위해서 객체로 만든 다음,Holder에 상속이다.
    public ViewHolderPage(@NonNull View itemView) {
        super(itemView);

        tv_title = itemView.findViewById(R.id.tv_title);
        rl_layout = itemView.findViewById(R.id.rl_layout);
    }

    // ViewAdapter에 적용할 바인더라고 하는듯. ViewAdapter에서 사용된다.
    public void onBind(DataPage data) {
        this.data = data;

        tv_title.setText(data.getTitle());
        rl_layout.setBackgroundResource(data.getColor());
    }
}
