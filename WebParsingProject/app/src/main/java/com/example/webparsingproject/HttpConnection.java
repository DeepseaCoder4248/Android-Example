package com.example.webparsingproject;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpConnection {
    // Square API
    // 라이브러리 implements
    // Internet Permission
    // https://square.github.io/okhttp/

    private OkHttpClient client;
    private static HttpConnection instance = new HttpConnection(); // 싱글턴 패턴 기반의 코드.

    // Activity에 HttpConnection 객체 호출.
    public static HttpConnection getInstance() {
        return instance; // 싱글턴 패턴으로 미리 받아 둔 객체화된 것을 Return한다.
    }

    // HTTP 객체 메소드
    private HttpConnection() {
        this.client = new OkHttpClient();
    }

    // GET 방식
    public void requestWeather(String lati, String longi, String key, Callback callback) { // 위,경,키,콜백 클래스
        // 웹통신의 방식: GET, POST

        // POST
//        RequestBody body = new FormBody.Builder()
//                .add("parameter", parameter)
//                .add("parameter2", parameter2)
//                .build();

        // GET
        Request request = new Request.Builder() // 요청 빌더 생성.
                .url("https://api.openweathermap.org/data/2.5/weather?lat=" + lati + "&lon=" + longi + "&appid=" + key)
//                .post(body)
                .build();
        client.newCall(request).enqueue(callback); // 대기열에 추가? 콜백은 무엇인가요?
    }

}

