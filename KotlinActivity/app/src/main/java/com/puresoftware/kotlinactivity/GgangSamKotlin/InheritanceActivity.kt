package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.puresoftware.kotlinactivity.R

class InheritanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inheritance)


//        var sub = Sub()
//        sub.main()

    }

    // 오버라이딩 상속
    open class Super() { // 상위클래스는 open으로 연다
        open var someData = 10 // override를 하려면 변수나 함수명에 open을 붙인다.
        open fun someFun() {
            Log.i("Inheritance", "Super class someData() - $someData")
        }
    }

    class Sub : Super() { // 하위클래스는 이렇게 한다
        override var someData = 20

        override fun someFun() {
            Log.i("Inheritance", "Sub class superData() - $someData")
        }
    }

//    // 일반적인 상속
//    open class Super() { // 상위클래스는 open으로 연다
//        var superData = 10
//        fun superFun() {
//            Log.i("Inheritance", "superData() - $superData")
//        }
//    }
//
//    class Sub : Super() { // 하위클래스는 이렇게 한다
//        fun main() {
//            val obj = Sub()
//            obj.superData = 20
//            obj.main()
//        }
//    }
}