package com.puresoftware.kotlinactivity.GgangSamKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.puresoftware.kotlinactivity.R
import com.puresoftware.kotlinactivity.databinding.ActivityListenerBinding

class ListenerActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityListenerBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.cb.setOnClickListener {
//            object : CompoundButton.OnCheckedChangeListener {
//                override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//                    Log.i("ListenerActivity", "compoundButton? - $p0 p1 - $p1")
//                    Log.i("ListenerActivity", "clicked")
//                }
//            }
//        }

        binding.cb.setOnCheckedChangeListener(this)


        // 리스너와 롱 클릭 리스터
        binding.btn.setOnClickListener {
            Log.i("ListenerActivity", "clicked")
        }
        binding.btn.setOnLongClickListener {
            Log.i("ListenerActivity", "long clicked")
            true // 이거 적어줘야 함
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.i("ListenerActivity", "compoundButton? - $p0 p1 - $p1")
        Log.i("ListenerActivity", "clicked")
    }
}