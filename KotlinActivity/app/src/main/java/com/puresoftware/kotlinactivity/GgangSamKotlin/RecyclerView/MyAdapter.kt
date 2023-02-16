package com.puresoftware.kotlinactivity.GgangSamKotlin.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puresoftware.kotlinactivity.databinding.ItemMainBinding

class MyAdapter(val binding: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = binding as MutableList<String> // 책에서 안알려줌. 직쩝 datas를 연동때여야 함.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang", "onbindBiewHolder:$position")

        val binding = (holder as MyViewHolder).binding // view에 data 출력

        binding.itemData.text = datas[position]

        binding.itemRoot.setOnClickListener {
            Log.i("kkang", "item root click $position")
        }
    }

    override fun getItemCount(): Int = datas.size
}