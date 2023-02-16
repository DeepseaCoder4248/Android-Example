package com.puresoftware.overlaprecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puresoftware.overlaprecyclerview.databinding.HolderRecyclerviewOutBinding
import com.puresoftware.overlaprecyclerview.model.RecyclerOutViewModel

class OutRecyclerViewAdapter(
    val context: Context, // 외부에서 가져올 Context 매개변수는 Activity
    val itemList: MutableList<RecyclerOutViewModel> // 바깥 Data가 담김
) : RecyclerView.Adapter<OutRecyclerViewAdapter.Holder>() { // 기본적 RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            HolderRecyclerviewOutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: HolderRecyclerviewOutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecyclerOutViewModel) {
            binding.model = item

            binding.innerRecyclerview.adapter = InRecyclerViewAdapter(context, item.innerList)
            binding.innerRecyclerview.layoutManager = LinearLayoutManager(context)
        }
    }
}