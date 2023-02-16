package com.puresoftware.overlaprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.puresoftware.overlaprecyclerview.databinding.ActivityMainBinding
import com.puresoftware.overlaprecyclerview.fragment.MainFragment

// https://kimyunseok.tistory.com/130
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(binding.container.id, MainFragment())
            .commit()
    }
}