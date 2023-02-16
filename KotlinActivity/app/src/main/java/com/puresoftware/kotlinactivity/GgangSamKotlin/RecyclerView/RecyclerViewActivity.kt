package com.puresoftware.kotlinactivity.GgangSamKotlin.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.puresoftware.kotlinactivity.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        for (i in 1..10) {
            datas.add("item $i")
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(this) // manager 즉시 초기화

        val layoutManager = LinearLayoutManager(this) // 변수를 담아서 초기화 선언
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL // 가로
//        val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false) // 그리드 가로
//        val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, true) // 그리드 세로


        binding.recyclerview.layoutManager = layoutManager

        binding.recyclerview.adapter = MyAdapter(datas)
        binding.recyclerview.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )


    }
}