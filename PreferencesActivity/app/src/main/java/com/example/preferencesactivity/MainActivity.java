package com.example.preferencesactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends PreferenceActivity {

    String TAG = MainActivity.class.getSimpleName();
    String keys;

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {

        // 키값 가져오기
        keys = preference.getKey();
        Log.i(TAG, "선택된 key는" + preference.getKey());

        // 가져온 키값을 기준으로 행동 실행.
        if (keys.equals("ringtone")) {
            Toast.makeText(MainActivity.this, "이것이 링톤인가.", Toast.LENGTH_SHORT).show();
        }
        if (keys.equals("activity")) {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
        }

        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        // 환경설정용 저장소 만들기
        SharedPreferences prefs; // 저장할 곳인듯.
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
    }
}