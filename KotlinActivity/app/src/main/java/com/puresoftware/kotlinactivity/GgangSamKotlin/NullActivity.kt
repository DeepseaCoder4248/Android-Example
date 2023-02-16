package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.puresoftware.kotlinactivity.R

class NullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null)

        var data: String? = null
        Log.i("NullActivity", "${data?.length ?: 0}") // data?.length가 data의 길이가 null 이면, 0을 리턴한다는 이야기다.

        var data2 :String? = "kkang"
        var length = data2?.length // data2의 길이가 널 이면 널을 대입하고, 아니면 그 값을 대입한다.
        Log.i("NullActivity",length.toString())

        var data3 : String? = null
        Log.i("NullActivity","${data!!.length}") // NullPointerException을 예외로 던져준다.




    }
}