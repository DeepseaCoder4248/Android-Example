package com.example.broadcastpassive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("gugu", "MyReceiver");
        Log.i("gugu", intent.getAction());
        Toast.makeText(context, "1111", Toast.LENGTH_SHORT).show();
    }














    public int wtf(){ // 내부클래스의 의미를 파악하기 위한 메소드 // public는 인스턴스 후 호출 가능.
        return 4;
    }

    private int wtf2(){ // 내부클래스의 의미를 파악하기 위한 메소드 // private는 인스턴스 후 호출 불가능.
        return 2;
    }

    protected int wtf3(){ // 내부클래스의 의미를 파악하기 위한 메소드 // protected는 인스턴스 후 호출 가능.
        return 3;
    }

    private void guide(){
//        public 접근 제한자: 단어 뜻 그대로 외부 클래스가 자유롭게 사용할 수 있도록 합니다.
//        protected 접근 제한자: 같은 패키지 또는 자식 클래스에서 사용할 수 있도록 합니다.
//        private 접근 제한자: 단어 뜻 그대로 개인적인 것이라 외부에서 사용될 수 없도록 합니다.
//        위 세 가지 접근 제한자가 적용되지 않으면 default 접근 제한을 가집니다.
//        default 접근 제한: 같은 패키지에 소속된 클래스에서만 사용할 수 있도록 합니다.
    }
}