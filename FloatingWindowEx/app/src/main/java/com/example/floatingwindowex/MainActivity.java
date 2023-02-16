package com.example.floatingwindowex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    AlertDialog dialog = null;

    ImageButton btnScreenResize;
    EditText edtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScreenResize = findViewById(R.id.btnScreenSize);
        edtMessage = findViewById(R.id.edtMessage);

        btnScreenResize.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.icon_minimize));


        if (isServiceRunning()) {
            // 이미 플로팅 서비스가 실행중이면 기존 서비스 제거
            stopService(new Intent(this, FloatingWindowService.class));
        }

        edtMessage.setText(Common.currentMessage);
        edtMessage.setSelection(Common.currentMessage.length());
        edtMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Common.currentMessage = edtMessage.getText().toString();

                Log.i("TAG", "currentMessage:"+Common.currentMessage);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnScreenResize.setOnClickListener(v -> {
            if (checkOverlayPermission()) {
                startService(new Intent(this, FloatingWindowService.class));
                finish();
            } else {
                requestFloatingWindowPermission();
            }
        });
    }

    private boolean isServiceRunning() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningServiceInfo serviceInfo : am.getRunningServices(Integer.MAX_VALUE)) {
            if (FloatingWindowService.class.getName().equals(serviceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void requestFloatingWindowPermission() {
        // Overlay Window를 띄우기 위해선 앱 권한 요청이 필요함.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Screen Overlay Permission Required");
        builder.setMessage("Enable 'Display over the App' from Settings");
        builder.setPositiveButton("Open Settings", (dialog, which) -> {
            Intent intent = new Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName())
            );

            startActivityForResult(intent, RESULT_OK);
        });
        dialog = builder.create();
        dialog.show();
    }

    private boolean checkOverlayPermission() {
        // 안드로이드 M 이상일 경우 시스템 권한 확인
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            return Settings.canDrawOverlays(this);
        } else {
            // M이 아닐 경우 기본적으로 가능
            return true;
        }
    }
}