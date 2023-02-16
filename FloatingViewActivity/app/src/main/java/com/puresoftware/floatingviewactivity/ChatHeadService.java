package com.puresoftware.floatingviewactivity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ChatHeadService extends Service {

    private FloatingViewManager mFloatingViewManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        DisplayMetrics metrics = new DisplayMetrics(); // android util
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE); // android view
        windowManager.getDefaultDisplay().getMetrics(metrics);
        LayoutInflater inflater = LayoutInflater.from(this);
        ImageView iconView = (ImageView) inflater.inflate(R.layout.widget_chathead, null, false);
        iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return super.onStartCommand(intent, flags, startId);


    }
}
