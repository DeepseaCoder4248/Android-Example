package com.example.listview6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    // ArrayList<데이터타입>
    ArrayList<ItemData> datas = new ArrayList<>();

    // 리스트뷰에 뿌려질 데이터가 몇칸이냐?
    // 내부적으로 리스트뷰에 몇칸 뿌려질지 궁금해서, 호출되는 메소드
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
        if (convertView == null) { // ConvertView(View)가 null이면. null을 주지 않으면 메모리가 과부하걸리고 중첩되어서 언젠가 오류 발생.
            Context context = parent.getContext(); // Context를 생성하면 getSystemService 호출이 가능하다. 무언가 얻어오는 Context는 반드시 getContext를 하기.

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // Inflater 권한을 가져온다.

            // 인플레이팅해서 반환받은 convertView가 있어서 레이아웃 요소에 접근이 가능하다
            convertView = inflater.inflate(R.layout.listview_item, parent, false); // converterView(View), Fragment나 infalter에서 다른 Activity에 쓰려면 View.findViewById는 필수다.
        }

    TextView oTextTitle = convertView.findViewById(R.id.textTitle); // 제목 텍스트 생성.
    TextView oTextDate = convertView.findViewById(R.id.textDate); // 날짜 텍스트 생성.
//        Button oButton = convertView.findViewById(R.id.btn_select);

    // 데이터를 뿌려주는 작업
    // 1) 데이터 객체를 얻어옴

    final ItemData data = datas.get(position);
    String date = data.strDate;
    String title = data.strTitle;

        oTextDate.setText(date);
        oTextTitle.setText(title);

//        oButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.i("Debug_KIM", "해당 위치 데이터: " + data.toString());
//
//
////                첫번째
////                클릭된　게시물　정보　（날짜，　제목）를　파이어베이스　ＤＢ에　저장하기
////                어떤　사용자가　ＤＢ에　저장했는지　알아야함　ａｂｃ
//
////                두번째
////                화면을　새로만들어서　
////                입력한　아이디가　저장한　게시물　리스트뷰로　뿌려주기
//                }
//        });


        return convertView; // convertView에는 inflate된 xml이 있다. 이걸 쓰려면 View로 return해서 다른 Activity에 쓰게 한다.
    }

    public void addItem(ItemData item) {// MainActivity에서 ItemData 값을 받아온다.
        datas.add(item);
    }
}
