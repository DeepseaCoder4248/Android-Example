package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.puresoftware.kotlinactivity.R

class CompanionClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companion_class)

        // 일반 클래스는 클래스명으로 뽑아오는 것이 불가능
//        val obj = MyClass()
//        obj.data = 20
//        MyClass.data = 20
//        MyClass.some()
//        val obj2 = MyClass.data

        MyClass.data
        MyClass.some()

    }

//    class MyClass {
//        var data = 10
//        fun some(){
//            Log.i("Companion Class","$data")
//        }
//    }

    class MyClass {
        companion object {
            var data = 10
            fun some() {
                Log.i("Companion Class", "$data")
            }
        }
        var result = data + 20
    }
}