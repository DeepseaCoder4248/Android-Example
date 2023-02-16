package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.puresoftware.kotlinactivity.R

class MotionEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_event)


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) { // 널을 들어올 경우 리턴하지 않음.
            MotionEvent.ACTION_DOWN -> Log.i(
                "MotionEvent",
                "touch down event x - ${event.x},raw x - ${event.rawX}"
            )
            MotionEvent.ACTION_UP -> Log.i("MotionEvent", "touch up event")
        }


        return super.onTouchEvent(event)
    }
}