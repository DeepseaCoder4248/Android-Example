package com.puresoftware.floatingwindow;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.Image;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class WidgetService extends Service {

    int LAYOUT_FLAG;
    View mFloatingView;
    WindowManager windowManager;
    ImageView imageClose;
    TextView tvWidth;
    float height, width;

    String TAG = WidgetService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // 안드로이드 버전에 따른 시스템 플래그
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY; // 안드로이드 버전 8.0부터는 이 플래그를 얻지 못하면 오버레이 불가능.
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        }
        Log.i(TAG, "LAYOUT_FLAG Status:" + LAYOUT_FLAG);


        // 우리가 만든 플로팅 뷰 레이아웃 확장,인플레이트하기
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.layout_widget, null);


        //위젯 아이콘의 레이아웃 파라미터를 넣기 위한 파라미터 객체 생성
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

//        Log.i(TAG, "LayoutParams WRAP_CONTENT(1):" + WindowManager.LayoutParams.WRAP_CONTENT);
//        Log.i(TAG, "LayoutParams WRAP_CONTENT(2):" + WindowManager.LayoutParams.WRAP_CONTENT);
//        Log.i(TAG, "LAYOUT_FLAG:" + LAYOUT_FLAG);
//        Log.i(TAG, "LayoutParams FLAG_NOT_FOCUSABLE:" + WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
//        Log.i(TAG, "PixelFormat.TRANSLUCENT:" + PixelFormat.TRANSLUCENT);

        // 위젯 아이콘의 레이아웃 파라미터
        layoutParams.gravity = Gravity.TOP | Gravity.RIGHT; // 아이콘의 레이아웃 그래비티 설정
        layoutParams.x = 0; // x값
        layoutParams.y = 100; // y값

        // 취소하는 레이아웃 파라미터를 넣기 위한 파라미터 객체 생성
        WindowManager.LayoutParams imageParams = new WindowManager.LayoutParams(
                140,
                140,
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        // 취소하는 레이아웃 파라미터
        imageParams.gravity = Gravity.BOTTOM | Gravity.CENTER;
        imageParams.y = 100;

        // 최종적으로 뷰를 뿌림.
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE); // WindowManager에서 서비스를 인스턴스

        // 취소하는 레이아웃의 뷰를 지정
        imageClose = new ImageView(this); // 새 이미지 뷰 생성.왜 하는지는 아직 잘 모르겠음.
        imageClose.setImageResource(R.drawable.ic_baseline_control_point_24); // 취소아이콘 등록
        imageClose.setVisibility(View.INVISIBLE);// 안보이게

        windowManager.addView(imageClose, imageParams); // 위에서 조절해준 파라미터 값을 넣음
        windowManager.addView(mFloatingView, layoutParams); // 위에서 조절해준 파라미터 값을넣음
        mFloatingView.setVisibility(View.VISIBLE);

        height = windowManager.getDefaultDisplay().getHeight();
        width = windowManager.getDefaultDisplay().getWidth();
        tvWidth = (TextView) mFloatingView.findViewById(R.id.imageView);

        // 사용자의 터치 동작을 사용하여 플로팅 뷰를 드래그하여 이동
        tvWidth.setOnTouchListener(new View.OnTouchListener() {

            int initialx, initialy;
            float initialTouchX, initialTouchY;
            long startCkickTime;

            // 클릭으로 볼 최대시간
            int MAX_CLICK_DURATION = 3000;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        startCkickTime = Calendar.getInstance().getTimeInMillis();
                        imageClose.setVisibility(View.VISIBLE);

                        // 초기 위치 기억
                        initialx = layoutParams.x;
                        initialy = layoutParams.y;

                        //터치 위치 좌표 얻기
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();

                        return true;

                    case MotionEvent.ACTION_UP:

                        long clickDuration = Calendar.getInstance().getTimeInMillis() - startCkickTime;
                        imageClose.setVisibility(view.GONE);


                        // 초기 좌표와 현재 좌표의 차이 가져 오기
                        layoutParams.x = initialx + (int) (initialTouchX - motionEvent.getRawX());
                        layoutParams.y = initialy + (int) (motionEvent.getRawY() - initialTouchY);

                        // 사용자가 플로팅 위젯을 제거 이미지로 끌어다 놓으면 서비스를 중지합니다.
                        if (clickDuration >= MAX_CLICK_DURATION) {
                            // 제거 이미지 주변 거리
                            if (layoutParams.y > (height * 0.6)) {
                                stopSelf();
                            }

                        }


                        return true;

                    case MotionEvent.ACTION_MOVE:

                        // 초기 좌표와 현재 좌표의 차이 가져 오기
                        layoutParams.x = initialx + (int) (initialTouchX - motionEvent.getRawX());
                        layoutParams.y = initialy + (int) (motionEvent.getRawY() - initialTouchY);

                        // 새로운 X 및 Y 좌표로 레이아웃 업데이트
                        windowManager.updateViewLayout(mFloatingView, layoutParams);

                        if (layoutParams.y > (height * 0.6)) {

                            imageClose.setImageResource(R.drawable.ic_baseline_control_point_24);
                        } else {
                            imageClose.setImageResource(R.drawable.ic_baseline_control_point_24);
                        }
                        return true;

                }
                return false;
            }
        });


        return START_STICKY;
    }

    // 앱이 종료될때 실행
    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mFloatingView != null) {
            windowManager.removeView(mFloatingView);

        }
        if (imageClose != null) {

            windowManager.removeView(imageClose);
        }

    }
}