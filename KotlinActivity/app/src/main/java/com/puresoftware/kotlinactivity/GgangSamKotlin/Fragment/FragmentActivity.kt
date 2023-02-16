package com.puresoftware.kotlinactivity.GgangSamKotlin.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.puresoftware.kotlinactivity.R
import com.puresoftware.kotlinactivity.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    val TAG: String = FragmentActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(TAG, "Fragment Activity 실행됨")

        val fragmentOne = OneFragment()
        val fragmentManager: FragmentManager =
            supportFragmentManager // 현재 이 class는 지금 Activity와 이름이 동일하여 package 명으로 확인하기.
        var transation: FragmentTransaction =
            fragmentManager.beginTransaction() // manager에서 이 method 가져오기

        transation.add(R.id.fragment_content, fragmentOne) // 추가하기
        transation.commit()

    }
}