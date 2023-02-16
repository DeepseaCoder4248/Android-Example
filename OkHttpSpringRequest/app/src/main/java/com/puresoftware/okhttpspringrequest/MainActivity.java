package com.puresoftware.okhttpspringrequest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button btnRequest;
    EditText edtText;
    EditText edtText2;
    TextView tvResult;

    String TAG = MainActivity.class.getSimpleName();

    // 전제 조건
    // 1.okHttp
    // 2.Spring 설정
    // 3.ngrok을 통한 포트 포워딩

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = findViewById(R.id.btn_request);
        edtText = findViewById(R.id.edt_text);
        edtText2 = findViewById(R.id.edt_text2);
        tvResult = findViewById(R.id.tv_result);

        OkHttpClient client = new OkHttpClient(); // client를위한 okhttp 생성

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request request = new Request.Builder().url("https://78dc-58-239-206-38.ngrok.io/project2/pong?name=홍길동&age=12").build();
                client.newCall(request).enqueue(callback);

            }
        });


    }

    Callback callback = new Callback() {
        @Override
        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
            // 승낙 응답

            Log.i(TAG, "request successed");
            String body = response.body().string(); // 응답이 성공하면 responce에 해당 값을 가져오고 body로 전달
            tvResult.setText(body);

        }

        @Override
        public void onFailure(@NonNull Call call, @NonNull IOException e) {
            // 비승낙 응답

            Log.i(TAG, "request failed");
            tvResult.setText("");

        }
    };
}