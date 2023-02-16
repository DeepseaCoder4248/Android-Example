package com.example.broadcastactive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("gugu","1111");
        Log.i("gugu","getAction: " +intent);
        Toast.makeText(context, "1111", Toast.LENGTH_SHORT).show();
    }
}