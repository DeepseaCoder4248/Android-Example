package com.example.listview6;

import androidx.annotation.NonNull;

public class ItemData {

    public String strTitle; // 제목을 저장.
    public String strDate; // 날짜를 저장.


//    알트+인서트

    @Override
    public String toString() {
        return "ItemData{" +
                "strTitle='" + strTitle + '\'' +
                ", strDate='" + strDate + '\'' +
                '}';
    }
}
