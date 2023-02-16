package com.puresoftware.snaphelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.puresoftware.snaphelper.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val todos = listOf(
        Todo("리싸이클러뷰 부시기 #1", false),
        Todo("리싸이클러뷰 부시기 #2", false),
        Todo("리싸이클러뷰 부시기 #3", false),
        Todo("리싸이클러뷰 부시기 #4", false),
        Todo("리싸이클러뷰 부시기 #5", false),
        Todo("리싸이클러뷰 부시기 #6", false),
        Todo("리싸이클러뷰 부시기 #7", false),
        Todo("리싸이클러뷰 부시기 #8", false),
        Todo("리싸이클러뷰 부시기 #9", false),
        Todo("리싸이클러뷰 부시기 #10", false),
        Todo("리싸이클러뷰 부시기 #11", false),
        Todo("리싸이클러뷰 부시기 #12", false),
        Todo("리싸이클러뷰 부시기 #13", false),
        Todo("리싸이클러뷰 부시기 #14", false),
        Todo("리싸이클러뷰 부시기 #15", false),
        Todo("리싸이클러뷰 부시기 #16", false),
        Todo("리싸이클러뷰 부시기 #17", false),
        Todo("리싸이클러뷰 부시기 #18", false),
        Todo("리싸이클러뷰 부시기 #19", false),
        Todo("리싸이클러뷰 부시기 #20", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
//        binding.todoList.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        binding.todoList.adapter = TodoAdapter(todos)

        // 이거는 gridlayot에서 스크롤 방향을 Horizontal로
        binding.todoList.layoutManager =
            GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
        binding.todoList.adapter = TodoAdapter(todos)

        // PagerSnapHelper 추가
        // PagerSnapHelper 추가
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.todoList)



    }
}