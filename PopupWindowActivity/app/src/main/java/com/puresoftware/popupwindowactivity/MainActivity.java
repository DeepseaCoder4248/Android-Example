package com.puresoftware.popupwindowactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //팝업을 띄우기 위하 버튼 하나 만들고
        ImageView btn = (ImageView) findViewById(R.id.btn_popup);
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                //클릭시 팝업 윈도우 생성
                PopupWindow popup = new PopupWindow(v);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //팝업으로 띄울 커스텀뷰를 설정하고
                View view = inflater.inflate(R.layout.test_popup_window, null);
                popup.setContentView(view);
                //팝업의 크기 설정
                popup.setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //팝업 뷰 터치 되도록
                popup.setTouchable(true);
                //팝업 뷰 포커스도 주고
                popup.setFocusable(true);
                //팝업 뷰 이외에도 터치되게 (터치시 팝업 닫기 위한 코드)
                popup.setOutsideTouchable(true);
                popup.setBackgroundDrawable(new BitmapDrawable());
                //인자로 넘겨준 v 아래로 보여주기

//                popup.showAsDropDown(btn);
//                popup.showAtLocation(view, Gravity.NO_GRAVITY, btn.getTop(), btn.getBottom());
//                popup.showAsDropDown(btn, 0, (int) btn.getTop() - 100);
                popup.showAtLocation(btn,0,0,0);

            }
        });

        ImageView btn2 = (ImageView) findViewById(R.id.btn_popup2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //클릭시 팝업 윈도우 생성
                PopupWindow popup = new PopupWindow(view);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //팝업으로 띄울 커스텀뷰를 설정하고
                View inflateView = inflater.inflate(R.layout.test_popup_window, null);
                popup.setContentView(inflateView);
                //팝업의 크기 설정
                popup.setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //팝업 뷰 터치 되도록
                popup.setTouchable(true);
                //팝업 뷰 포커스도 주고
                popup.setFocusable(true);
                //팝업 뷰 이외에도 터치되게 (터치시 팝업 닫기 위한 코드)
                popup.setOutsideTouchable(true);
                popup.setBackgroundDrawable(new BitmapDrawable());
                //인자로 넘겨준 v 아래로 보여주기

//                popup.showAsDropDown(btn);
//                popup.showAtLocation(view, Gravity.NO_GRAVITY, btn.getTop(), btn.getBottom());
                popup.showAsDropDown(btn2, 0, -500);

            }
        });

    }

}