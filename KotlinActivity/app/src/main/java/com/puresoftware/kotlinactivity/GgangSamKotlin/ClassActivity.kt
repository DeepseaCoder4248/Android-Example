package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.puresoftware.kotlinactivity.R

class ClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        val user = User("Kkang", 10)
    }

    class User(var name:String){

        constructor(name:String,count:Int):this(name){
        }

        constructor(name:String,tag:String,code:Int):this(name){
        }

//        // 최상단에 있는 생성자의 매개변수 name이 없으므로 사용이 불가능.
//        constructor(count:Int):this(name){
//        }

//        // 최상단에 있는 생성자 디자인과 같으므로 필요없음.
//        constructor(name: String):this(name){}
    }

//    // 주 생성자에 var를 넣어서 선언하면 아무 메소드에서도 사용이 가능하다.
//    class User(var name: String, val count: Int) {
//
//        init {
//            Log.i("gugu", "init - name: ${name}, count: ${count}")
//        }
//
//        fun someFun() {
//            Log.i("gugu", "somefun() - name: ${name}, count: ${count}")
//        }
//    }

//    // constructor
//    class User {
//
//        var name = "kkang"
//        var count = 0
//
//        constructor(name:String,count:Int){ // 기본 생성자
//            this.name = name
//        }
//        fun someFun(){
//            Log.i("gugu","name: $name")
//        }
//        class SomeClass{}
//
//    }

//    // init
//    class User(name: String, count: Int) {
//
//        init {
//            Log.i("gugu","name: ${name}, count: ${count}")
//        }
//
////        // 일반 메소드에서는 생성자의 매개변수를 쓸 수 없다.
////        fun someFun() {
////            Log.i("gugu", "name: ${name}")
////        }
////
////        //        이미 위쪽에서 init과 constructor를 선언했으므로 추가적으로 하는 것 불가능.
////        constructor() {
////        }
//    }
}