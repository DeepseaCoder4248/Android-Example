package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.puresoftware.kotlinactivity.R

class LamdaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lamda)

        main()
        main2()
        main3()


    }

    // 매개변수가 1개인 람다
    fun main() {
        val some = { no: Int -> Log.i("lamdaActivity", "lamda1: $no") }
        some(10)
    }

    // 타입 미지정 람다
    fun main2() {
        val some: (Int) -> Unit = { Log.i("lamdaActivity", "lamda2: $it") }
        some(15)
    }

    // 람다함수 리턴
    fun main3() {
        val some = { no1: Int, no2: Int -> Log.i("lamdaActivity", "lamda3: ${no1 * no2}") }
        some(10, 20)
    }
}

typealias MyFunType = (Int, Int) -> Boolean

