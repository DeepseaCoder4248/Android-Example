package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.puresoftware.kotlinactivity.R
import com.puresoftware.kotlinactivity.databinding.ActivityViewVindingBinding

class ViewVindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩
        val binding = ActivityViewVindingBinding.inflate(layoutInflater) // activity_view_binding.xml의 클래스는 ActivityViewBinding + Binding으로 붙여진 이름이다. 인플레이터는 그대로 있다.
        setContentView(binding.root)

        // visible 버튼을 누르면 targetView가 보이겣
        binding.visibleBtn.setOnClickListener {
            binding.targetView.visibility = View.VISIBLE
        }

        // invisible 버튼을 누르면 targetView가 안보이겣
        binding.invisibleBtn.setOnClickListener {
            binding.targetView.visibility = View.INVISIBLE
        }

    }
}