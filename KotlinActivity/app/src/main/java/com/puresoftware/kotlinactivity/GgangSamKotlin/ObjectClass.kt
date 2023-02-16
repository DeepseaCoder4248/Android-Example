package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puresoftware.kotlinactivity.R

class ObjectClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_class)

        // 익명 클래스는 클래스를 단독으로 쓰는 게 아님. 그래서 호출 자체가 불가능하다.
//        val datas:Int = objClass.data // 불가능한 코드
//        objClass.some() // 불가능한 함수

        obj.data = 20
        obj.some()
    }

//    val objClass = object{
//        var data:Int = 10
//
//        fun some(){
//            println("data : $data")
//        }
//    }

    // 일단 아무한테나 상속을 받은 다음, 쓸 수 있다.
    val obj = object : SuperClass(){
        override var data = 10

        override fun some(){
            println("data : $data")
        }
    }

    // 상속해줄 상위 클래스
    open class SuperClass{
        open var data = 10
        open fun some(){
            println("data : $data")
        }
    }
}