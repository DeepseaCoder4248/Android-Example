package com.example.webparsingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

// 웹통신, 블루투스, NFC, 응용
// 코드최적화 (코드를 작성하는 패턴) - MVC, MVP, MVVM (당근마켓, 토스, )
// 싱글턴패턴 (고유한 객체를 받아오는 형태)

// 영상처리학문 -> C, C++, python
public class MainActivity extends AppCompatActivity {

    EditText edt1; // 위도
    EditText edt2; // 경도
    Button btn; // openWeather로 보내기
    TextView textView; // 값 전시
    String TAG = MainActivity.class.getSimpleName(); // ?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 연동
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.tv);

        // 버튼을 누르면 openWeather에 좌표를 전달하고 정보를 받아오기.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // edittext에서 위도, 경도를 받아와서
                // API요청
                // 응답값 받아와서 Textview에 출력하기
//                String latitude = edt1.getText().toString();
//                String longtitude = edt2.getText().toString();

                // 서울 지역
                String latitude = "37.5549118"; // 위도
                String longtitude = "126.8369136"; // 경도

                // API요청
                HttpConnection conn = HttpConnection.getInstance(); // 객체화 된 것을 받아오기

                conn.requestWeather(latitude,longtitude,"24873ecd8e3bc2d0dd039257d0d73eb4", callback); // 내용을 집어넣기.
            }
        });
    }

//    Callback callback2 = new Callback() {
//        @Override
//        public void onFailure(Call call, IOException e) {
//
//        }
//
//        @Override
//        public void onResponse(Call call, Response response) throws IOException {
//
//        }
//    };

    // Callback Override : A클래스의 정보가 B클래스에게 요청을 하면 B클래스의 정보를 가져온다.
    private final Callback callback = new Callback() { // ?
        @Override

        // 콜백에서 실패하면 메세지 전시.
        public void onFailure(Call call, IOException e) {
            Log.d(TAG, "콜백오류:"+e.getMessage());
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String body = response.body().string(); // 응답 내용을 한번만 받는 듯 하다.

            // 외부에서 값 가져옴.
            // 원하는 값을 뽑아온다 (파싱)
            // gson은 json값을 쉽게 파싱할수있도록 도와주는 라이브러리
            Log.d(TAG, "서버에서 응답한 Body:"+body);

            // Gson : Json 데이터를 JAVA로 변환 또는 반대로 변환하는 라이브러리.
            Gson gson = new Gson();

            // 형변환, Json에서 java로 변환한다.
            JsonObject root = gson.fromJson(body, JsonObject.class); // (Json으로 받아 온 데이터,JsonObject.클래스)

            // JsonArray로 변환.
            JsonArray weatherArray = root.getAsJsonArray("weather");
            Log.d(TAG, "array: " + weatherArray.toString());



            JsonObject weather = weatherArray.get(0).getAsJsonObject();
            Log.d(TAG, "main: " + weather.get("main").toString());
            Log.d(TAG, "description: " + weather.get("description").toString());
//            for(int i=0; i<weatherArray.size(); i++) {
//                JsonObject weather = weatherArray.get(i).getAsJsonObject();
//                Log.d(TAG, "weather "+ i +" : " + weather.toString());
//            }

            JsonObject mains = root.getAsJsonObject("main");
            double temp = Double.parseDouble(mains.get("temp").toString()) - 277;
            // 277 뺴주기
            Log.d(TAG, "temp: " + temp);
        }
    };

}