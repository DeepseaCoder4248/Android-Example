package com.puresoftware.floatingwindow;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.notify_me);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                // 오버레이 권한창이 아니라면,메소드 실행
                if (!Settings.canDrawOverlays(MainActivity.this)) {
                    getpermission();

                } else {
                    // 권한이 설정돼있으면 위젯 클래스로 연결
                    // 서비스로 보내는 intent, 서비스는 따로 서비스 클래스를 만들어야 한다. 여기서는 WidgetService(Service class 상속)
                    Intent intent = new Intent(MainActivity.this, WidgetService.class);
                    startService(intent);
                    finish();
                }
            }
        });
    }


    // M 버전(안드로이드 6.0 마시멜로우 버전) 보다 같거나 큰 API에서만 설정창 이동 가능
    public void getpermission() {

        // 버전이 마시멜로보다 크고, 오버레이 권한 창이 아니라면
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())); // 오버레이 권한 창으로 가는 것.
            startActivityForResult(intent, 1); // 요청코드를 onActivityResult 메소드로 던져줌.

            Log.i(TAG, "intent data:" + intent + "\n" + "phone ver:" + Build.VERSION.SDK);
        }
    }

    // WidgetService 에서 처리된 결과를 받는 메소드
    // 처리된 결과 코드가 requestCode 를 판별해 결과 처리를 진행한다.
    // WidgetService 에서 처리 결과가 담겨온 데이터를 메시지로 보여준다.
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i(TAG, "request:" + requestCode + ",result:" + resultCode + ",intent data:" + data);

//        // 권한 여부 확인
//        if (requestCode == 1) {
//            // 권한을 사용할 수없는 경우 알림 표시
//            if (!Settings.canDrawOverlays(MainActivity.this)) {
//                Toast.makeText(this, "Permission denied by user", Toast.LENGTH_SHORT).show();
//
//                Log.i(TAG, "!Settings.canDrawOverlays status:" + Settings.canDrawOverlays(this));
//            }
//        }
    }
}