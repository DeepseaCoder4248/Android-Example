package com.example.ocr_real;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpConnection {

    private OkHttpClient client; // okHttp 객체
    private static HttpConnection instanse = new HttpConnection(); // 싱글턴 패턴으로 Http 가져오기

    public static HttpConnection getInstance() { // 싱글턴 메소드를 호출한다. http를 호출한다.
        return instanse;
    }

    // ?
    private HttpConnection() {
        this.client = new OkHttpClient(); // ?
    }

    // Data 과정 방식 정하기 get인가 post인가?
    // get

    // 사진을 전송하기 전까지
    public void requestOCR(Callback callback) {
        Request request = new Request.Builder() // uri 호출
                .addHeader("X-OCR-SECRET", "ZHFNQmZmeVZxc3dUZlljVGh4dk5ISkZValFvYWRRS0Q=")
                .addHeader("Content-Type", "application/json")
                .url("https://458a5a4b7b2e45a884448d359d3381d0.apigw.ntruss.com/custom/v1/")
                .build(); // 빌드하기
        client.newCall(request).enqueue(callback); // 모름
    }
}
