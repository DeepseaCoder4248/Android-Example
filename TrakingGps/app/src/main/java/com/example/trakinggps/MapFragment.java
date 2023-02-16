package com.example.trakinggps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;

public class MapFragment extends Fragment implements TMapGpsManager.onLocationChangedCallback { // 인터넷 안키고 하면 안보인다.

    TMapView tMapView; // Tmap
    Context context; // 프래그먼트 클래스에서 가져올 컨텍스트
    LocationManager locationManager; // GPS
    TMapMarkerItem tMapMarkerItem; // Tmap 마커
    TMapPoint tMapPoint; // Tmap에 쓸 좌표
    Bitmap markerBitmap; // 비트맵 가져오기

    int count; // Tmap 마커에 ID 갯수를 1씩 증가

    FirebaseFirestore db; // DB

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getContext(); // 컨텍스트 호출
        db = FirebaseFirestore.getInstance(); // DB 호출
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE); // 내부 시스템이므로 context.getSystemSerVice 사용.

        if (ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        } else { // 10초,1미터마다 변경.
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 10000, 1, mLocationListener); // GPS 모드
            locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 10000, 1, mLocationListener); // 네트워크 모드
        }

        View view = inflater.inflate(R.layout.marp_fragment, container, false); // 인플레이터

        LinearLayout layTmap = view.findViewById(R.id.lay_tMap); // Tmap이 전시 될 레이아웃

        // Tmap
        tMapView = new TMapView(context); // 해당 클래스에서 context하기
        tMapView.setSKTMapApiKey("l7xx220d894acf06462b8004d9b0fab6f769"); // Tmap ID
        layTmap.addView(tMapView);

        tMapView.setTrackingMode(true); // 추적 모드 시작
        tMapView.setSightVisible(true); // 초록색 사이트
        tMapView.setIconVisibility(true); // 파란 아이콘

        return view;
    }

    @Override
    public void onLocationChange(Location location) {
    }

    // Android GPS 활성 여부 체크후 위치 변경마다 값 전송.
    private LocationListener mLocationListener = new LocationListener() { // 메소드 오버라이딩을 하여 모두 불러오기.

        @Override
        public void onProviderEnabled(@NonNull String provider) { // 장비가 활성화 상태일 때.
            Toast.makeText(context, "활성화 상태", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderDisabled(@NonNull String provider) { // 장비가 비활성화 상태일 때.
            Toast.makeText(context, "비 활성화 상태", Toast.LENGTH_SHORT).show();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onLocationChanged(@NonNull Location location) { // 위치가 변경될 때.
            double longtitude = location.getLongitude(); // 경도
            double latitude = location.getLatitude(); // 위도
            double altitude = location.getAltitude(); // 고도
            float accuracy = location.getAccuracy(); // 정확도
            String provider = location.getProvider(); // 수신 타입
            Toast.makeText(context, "위치 바뀜", Toast.LENGTH_SHORT).show(); // 위치가 바뀔 때마다.

            // 소숫점 6자리로 표시
            longtitude = Double.parseDouble((String.format("%.6f",longtitude)));
            latitude = Double.parseDouble((String.format("%.6f",latitude)));

            // Tmap으로 위치 정보
            tMapView.setLocationPoint(longtitude, latitude); // Tmap에서 해당 위치에서 화면을 계속 이동하게 할 수 있도록.
            tMapPoint = new TMapPoint(latitude, longtitude); // 항상 반복문으로 인해 새로운 객체가 생성되어야 한다면 new로 해당 객체도 매번 새롭게 생성할 수 있도록 한다.

            // Tmap Icon
            tMapMarkerItem = new TMapMarkerItem(); // Icon 객체.
            markerBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_baseline_arrow_drop_down_24); // 거 아무거나 마커 표시 할 디자인. 공부가 필요함.
            tMapMarkerItem.setIcon(markerBitmap); // Tmap 마커 생성.
            tMapMarkerItem.setPosition(0.5f, 0.9f); // Tmap 마커에서 대략적으로 찍히는 오차위치? 잘 모름.
            tMapMarkerItem.setTMapPoint(tMapPoint); // tMap 객체로 가져와서 위,경도 넣기.
            tMapMarkerItem.setName("현재 위치 + 시간"); // 시간
            tMapView.addMarkerItem("marker" + count++, tMapMarkerItem); // 지도에 마커 추가 count를 추가하여 새로운 Id를 생성할 수 있도록 만들었음.
            // 확인 한 바로는 TmapGps의 기능들이 기본 안드로이드 GPS 기능이랑 동일하고 따로 Tmap의 기능을 빨리 쓰기 위해 클래스등으로 구분한 것으로 추측함.

            // 시간 가져오기
            long nowTime = System.currentTimeMillis();
            Date date = new Date();

            // 2021 01 08 ~~
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            String documentTime = simpleDateFormat.format(date);

            Map<String,Object> data = new HashMap<>();
            data.put("1.센서 타입",provider);
            data.put("2.시간",documentTime); // 가져오기에서 String 문제가 있어 cast가 불가능하므로 기존 클래스를 사용.
            data.put("3.위도",latitude);
            data.put("4.경도",longtitude);
            data.put("5.고도",altitude);
            data.put("6.정확도",altitude);

            Log.i("tag",
                            "/ 센서 타입: " + provider +
                            "/ 위도: " + latitude +
                            "/ 경도: " + longtitude +
                            "/ 고도: " + altitude +
                            "/ 정확도: " + accuracy);

            db.collection("userInfo").document(documentTime).set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Log.i("tag","업로드를 성공하였습니다");
                }
            });
        }
    };
}
