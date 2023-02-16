package com.puresoftware.ch11_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ch11_jetpack.OneFragment
import com.example.ch11_jetpack.ThreeFragment
import com.example.ch11_jetpack.TwoFragment
import com.puresoftware.ch11_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    // fragment를 생성. 권장하지 않음
    class MyFragmentPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

        val fragments: List<Fragment> =
            listOf(OneFragment(), TwoFragment(), ThreeFragment()) // fragment를 담을 List

        override fun getItemCount(): Int = fragments.size // fragment 갯수

        override fun createFragment(position: Int): Fragment = fragments[position] // fragment 생성


    }
}