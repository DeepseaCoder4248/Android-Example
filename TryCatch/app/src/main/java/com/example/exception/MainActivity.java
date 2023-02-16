package com.example.exception;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            onAction();
        } catch (Exception sdfg) {
            System.out.println("onAction에서 6을 발견했나 봅니다.");
        } finally {
            System.out.println("try-catch문을 종료하고 finnaly문을 처리합니다.");
        }
    }

    public static void onAction() throws Exception {
        for (int i = 0; i < 10; i++) {
            try {
                if (i != 6) {
                    System.out.println(i+"는 6이 아닙니다");
                }else{
                    throw new Exception();
                }
            }catch(Exception sacaca){
                System.out.println(i+"는 6이 맞네요. CheckException이 onAction()서 발생");

            }
        }
    }
}