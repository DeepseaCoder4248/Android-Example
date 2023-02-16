package com.example.tmap2;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.List;

import static com.example.tmap2.R.drawable.icon;

public class MainActivity extends AppCompatActivity {

    TMapView tmapVIew; // Tmap 객체.
    LinearLayout layTmap; // Tmap 뷰.

    EditText edtLong1; // 1의 경도 정보.
    EditText edtLati1; // 1의 위도 정보.
    EditText edtLong2; // 2의 경도 정보.
    EditText edtLati2; // 2의 위도 정보.
    Button btnMeasure; // 측정하기.
    double Long1; // 1의 경도 정보 저장.
    double Lati1; // 1의 위도 정보 저장.
    double Long2; // 2의 경도 정보 저장.
    double Lati2; // 2의 위도 정보 저장.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPermission();

        tmapVIew = new TMapView(this);
        tmapVIew.setSKTMapApiKey("l7xx220d894acf06462b8004d9b0fab6f769"); // API 키
        layTmap = findViewById(R.id.lay_tmap);
        layTmap.addView(tmapVIew);

        tmapVIew.setTrackingMode(true);
        tmapVIew.setLocationPoint(126.975189, 37.565824); // 덕수궁
        tmapVIew.setIconVisibility(true);

        edtLati1 = findViewById(R.id.edt_lati1);
        edtLong1 = findViewById(R.id.edt_long1);
        edtLati2 = findViewById(R.id.edt_lati2);
        edtLong2 = findViewById(R.id.edt_long2);

        btnMeasure = findViewById(R.id.btn_measure);
        btnMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                measure();

            }
        });
    }

    private void startPermission() {
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("GPS를 사용하기 위해 권한 허가가 필요합니다.")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
                .check();
    }

    PermissionListener permissionlistener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(MainActivity.this, "권한이 허가되었습니다.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPermissionDenied(List<String> deniedPermissions) {
            Toast.makeText(MainActivity.this, "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show();
        }


    };

    // 거리를 측정하고 측정한 좌표와 거리를 표시.
    public void measure() {
        try {
            Long1 = Double.parseDouble(edtLong1.getText().toString()); // 1의 경도 정보를 입력받고 저장.
            Lati1 = Double.parseDouble(edtLati1.getText().toString()); // 1의 위도 정보를 입력받고 저장.
            Long2 = Double.parseDouble(edtLong2.getText().toString()); // 2의 경도 정보를 입력받고 저장.
            Lati2 = Double.parseDouble(edtLati2.getText().toString()); // 2의 위도 정보를 입력받고 저장.

            ArrayList<TMapPoint> alTMapPoint = new ArrayList<TMapPoint>(); // Tmap의 좌표들을 객체 배열화.
            alTMapPoint.add(new TMapPoint(Lati1, Long1)); // 좌표 입력.
            alTMapPoint.add(new TMapPoint(Lati2, Long2)); // 만약 타입 캐스팅이 가능할까?

            TMapPolyLine tMapPolyLine = new TMapPolyLine(); // Tmap 선 객체.
            tMapPolyLine.setLineColor(Color.GREEN); // 색상은 초록색.
            tMapPolyLine.setLineWidth(3); // 굵기는 3.
            for (int i = 0; i < alTMapPoint.size(); i++) { // i가 0일 때 alTMapoint 배열의 길이만큼 코드를 실행하고 i는 1씩 반복한다
                tMapPolyLine.addLinePoint(alTMapPoint.get(i)); // 흐름은 알겠는데 구조는 모르겠다.
            }

            tmapVIew.addTMapPolyLine("Line", tMapPolyLine);
            Log.i("data", String.valueOf(tMapPolyLine));
            double Distance = tMapPolyLine.getDistance();
//        int resultDistance = (int) Distance;
            Toast.makeText
                    (getApplicationContext(), "위치 1:" + String.valueOf(Long1 + "," + Lati1)
                            + "\n" + "위치 2:" + String.valueOf(Long2 + "," + Lati2)
                            + "\n" + "거리: " + String.valueOf(Math.floor(Distance) + "M"), Toast.LENGTH_LONG).show(); // /n은 줄 넘기기. Math.floor는 소숫점 버리기.
            Log.i("distance", String.valueOf(Distance));

        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "입력해주세요", Toast.LENGTH_SHORT).show();
            {
            }
        }
    }
}