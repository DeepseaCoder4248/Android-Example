package com.example.ch11_jetpack

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puresoftware.ch11_jetpack.R
import com.puresoftware.ch11_jetpack.databinding.FragmentOneBinding
import com.puresoftware.ch11_jetpack.databinding.ItemRecyclerviewBinding

class OneFragment : Fragment() {

    // 내부에 Adapter를 추가하는 방법
    class MyAdapter(val datas: MutableList<String>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        // RecyclerView를 inflate.권장하지 않음
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            MyViewHolder(
                ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

        // Item에 정보를 뿌림.권장하지 않음
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val binding = (holder as MyViewHolder).binding
            binding.itemData.text = datas[position] // item 뿌려주는 것. TextView임.

        }

        // item의 Count
        override fun getItemCount(): Int {
            return datas.size
        }
    }

    // 보통은 itemView를 통해서 findViewID를 하게 되지만, binding을 통해서 한다. 솔직히 binding 기술 자체를 추천하지 않는다.
    class MyViewHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    // RecyclerView를 꾸며주는 Class
    class MyDecoration(val context: Context) : RecyclerView.ItemDecoration() {

        // RecyclerView의 모든 게 호출 된 후
        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDrawOver(c, parent, state)

            // View 크기
            val width = parent.width
            val height = parent.height

            // Image 크기
            val dr: Drawable? = ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.kbo,
                null
            ) // Image를 가져오는 듯
            val drWidth = dr?.intrinsicWidth // 고유 너비
            val drHeight = dr?.intrinsicHeight // 고유 높이

            // 이미지를 출력할 위치 계산
            val left = width / 2 - drWidth?.div(2) as Int
            val top = height / 2 - drHeight?.div(2) as Int

            c.drawBitmap(
                BitmapFactory.decodeResource(context.resources, R.drawable.kbo),
                left.toFloat(),
                top.toFloat(),
                null
            )
        }

        // 항목 꾸미기
        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)

            val index = parent.getChildAdapterPosition(view) + 1

            if (index % 3 == 0) {
                outRect.set(10, 10, 10, 60)
            } else {
                outRect.set(10, 10, 10, 0)
            }
            view.setBackgroundColor(Color.parseColor("#28A0FF"))
            ViewCompat.setElevation(view, 20.0f)

        }
    }

    // Fragment onCreateView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(inflater, container, false)
        val datas = mutableListOf<String>()

        // Item을 반복문을 통해 넣는 것
        for (i in 1..9) {
            datas.add("item ${i}")
        }

        // layoutManager 기본
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager

        // adapter
        val adapter = MyAdapter(datas)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))
        return binding.root
    }
}