package com.puresoftware.lifecycle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoSub = findViewById<Button>(R.id.btn_go_sub)

        var intent:Intent = Intent(this,Subactivity::class.java)

        btnGoSub.setOnClickListener {
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Log.i(TAG,"onCreate 실행")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart 실행")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"onResume 실행")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"onPause 실행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"onRestart 실행")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop 실행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy 실행")
    }
}