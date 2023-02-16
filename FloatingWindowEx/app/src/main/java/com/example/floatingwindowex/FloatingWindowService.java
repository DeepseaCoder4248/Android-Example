package com.example.floatingwindowex;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;

public class FloatingWindowService extends Service {

    private ViewGroup floatView;
    private WindowManager.LayoutParams floatViewLayoutParams;
    private int LAYOUT_TYPE;
    private WindowManager wm;

    ImageButton btnScreenResize;
    EditText edtMessage;



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        floatView = (ViewGroup) inflater.inflate(R.layout.activity_main, null); // 서비스 실행 시 View 를 새로 Inflate 한다.
        btnScreenResize = floatView.findViewById(R.id.btnScreenSize);
        edtMessage = floatView.findViewById(R.id.edtMessage);

        btnScreenResize.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.icon_maximize));

        edtMessage.setText(Common.currentMessage);
        edtMessage.setSelection(Common.currentMessage.length());
        edtMessage.setCursorVisible(false);
        edtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Common.currentMessage = edtMessage.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtMessage.setOnTouchListener((v, event) -> {
            edtMessage.setCursorVisible(true);
            WindowManager.LayoutParams layoutParams = floatViewLayoutParams;
            layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

            wm.updateViewLayout(floatView, layoutParams);
            return false;
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_TOAST;
        }

        floatViewLayoutParams = new WindowManager.LayoutParams(
                ((int) (width * 0.9f)), // 축소 될때 윈도우 해상도 값. X축
                ((int) (height * 0.6f)), // 축소 될때 윈도우 해상도 값. Y축
                LAYOUT_TYPE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        floatViewLayoutParams.gravity = Gravity.CENTER;
        floatViewLayoutParams.x = 0;
        floatViewLayoutParams.y = 0;

        wm.addView(floatView, floatViewLayoutParams);

        btnScreenResize.setOnClickListener(v -> {
            stopSelf();
            wm.removeView(floatView);
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        floatView.setOnTouchListener(new View.OnTouchListener() {
            final WindowManager.LayoutParams updateWindowParam = floatViewLayoutParams;
            double x = 0.0;
            double y = 0.0;
            double px = 0.0;
            double py = 0.0;


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (double) updateWindowParam.x;
                        y = (double) updateWindowParam.y;

                        px = (double) event.getRawX();
                        py = (double) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        updateWindowParam.x = (int) (x + event.getRawX() - px);
                        updateWindowParam.y = (int) (y + event.getRawY() - py);
                        wm.updateViewLayout(floatView, updateWindowParam);
                        break;
                }

                return false;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
        wm.removeView(floatView); // 서비스 Destroy 시 오버레이 윈도우 제거
    }
}
