package com.puresoftware.recycler2x2viewpager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // logic test
        var tv1 = findViewById<TextView>(R.id.tv_1)
        var tv2 = findViewById<TextView>(R.id.tv_2)
        var tv3 = findViewById<TextView>(R.id.tv_3)
        var tv4 = findViewById<TextView>(R.id.tv_4)

        val datalist = ArrayList<String>()
        val resultIt1 = ArrayList<String>()
        val resultIt2 = ArrayList<String>()
        val resultIt3 = ArrayList<String>()
        val resultIt4 = ArrayList<String>()

//        datalist.add("1번 데이터")
//        datalist.add("2번 데이터")
//        datalist.add("3번 데이터")
//        datalist.add("4번 데이터")
//        datalist.add("5번 데이터")
//        datalist.add("6번 데이터")
//        datalist.add("7번 데이터")
//        datalist.add("8번 데이터")

        // 여기서는 1부터 시작하는 듯.
        for (i in 0..99) {
            datalist.add("" + i  + "번 데이터")
        }

        var it1 = true
        var it2 = false
        var it3 = false
        var it4 = false

        // data load
        for (i in 0..datalist.size - 1) {
            val data = datalist[i]


            if (it1 == true) { // 이녀석은 바로 완전 item을 넣는거고
                tv1.text = data
                resultIt1.add(data)

                it1 = false
                it2 = true
                it3 = false
                it4 = false
            } else if (it2 == true) { // 그 옆에 있는 것들
                tv2.text = data
                resultIt2.add(data)

                it1 = false
                it2 = false
                it3 = true
                it4 = false
            } else if (it3 == true) {
                tv3.text = data
                resultIt3.add(data)

                it1 = false
                it2 = false
                it3 = false
                it4 = true
            } else if (it4 == true) {
                tv4.text = data
                resultIt4.add(data)

                it1 = true
                it2 = false
                it3 = false
                it4 = false
            }
        }
        Log.i("TAG", "Result 1" + resultIt1)
        Log.i("TAG", "Result 2" + resultIt2)
        Log.i("TAG", "Result 3" + resultIt3)
        Log.i("TAG", "Result 4" + resultIt4)
    }
}