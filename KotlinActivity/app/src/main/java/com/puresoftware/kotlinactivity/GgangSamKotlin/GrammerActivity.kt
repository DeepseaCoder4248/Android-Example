package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.puresoftware.kotlinactivity.R

class GrammerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammer)

        // 반복문
        var sum = 0
        for(i in 1..10 ){
            sum += i // 이 식의 경우는 i가 1일때 sum에 1이 들어가고, i가 2일때 sum에 있는 걸 더해서 sum은 3이 되고 i가 3일때 sum에 있는 걸 더해서 sum은 6이되는 식이다.

            Log.i("gugu","sum은 ${sum}, i는 $i,")
        }
    }
}