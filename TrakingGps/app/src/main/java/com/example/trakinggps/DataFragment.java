package com.example.trakinggps;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview, container, false);

        final ListView listView = view.findViewById(R.id.listview); // 리스트 뷰

        FirebaseFirestore db = FirebaseFirestore.getInstance(); // DB
        final ListAdapter listAdapter = new ListAdapter(); // 어댑터

        // DB 불러오기 성공하면 리스트 뷰에 위치 정보 전시하기
        db.collection("userInfo").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot snapshot : task.getResult()) {
                        Map<String, Object> forms = snapshot.getData(); // 저장된 객체가 Hash므로 Hash로 불러온다.

                        String getTime = String.valueOf(snapshot.getData().get("2.시간")); // Cast를 하게 되면 같은 종류의 타입이 발견될 경우 오류가 발생한다. 특히 String.
                        String getLati = String.valueOf(snapshot.getData().get("3.위도"));
                        String getLong = String.valueOf(snapshot.getData().get("4.경도"));

                        Log.i("tag", "시간: " + getTime + "/위도:" + getLati + "/경도: " + getLong);
                        // https://finewoo.tistory.com/175

                        // 리스트 뷰 전시
                        ItemData itemData = new ItemData();
                        itemData.location = getLati + " "+getLong;
                        itemData.log = getTime;
                        listAdapter.addItem(itemData);
                        listView.setAdapter(listAdapter);
                    }
                }
            }
        });
        return view;
    }
}
