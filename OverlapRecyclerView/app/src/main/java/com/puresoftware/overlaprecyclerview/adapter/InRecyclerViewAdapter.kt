package com.puresoftware.overlaprecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puresoftware.overlaprecyclerview.databinding.HolderRecyclerviewInBinding
import com.puresoftware.overlaprecyclerview.model.RecyclerInViewModel

class InRecyclerViewAdapter(context: Context, val itemList: MutableList<RecyclerInViewModel>) :
    RecyclerView.Adapter<InRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            HolderRecyclerviewInBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: HolderRecyclerviewInBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecyclerInViewModel) {
            binding.model = item
        }
    }

}