package com.puresoftware.aacmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.puresoftware.aacmvvm.databinding.ActivityMainBinding

// Activity
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // instance
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        // ViewModel에 database 넣기
        viewModel.setDatabase(ModelDatabase())

        // 람다식 기반의
        viewModel.info.observe(this) {
            binding.viewModel = viewModel
        }

        //        // observe. 구버전
//        viewModel.info.observe(this, Observer {
//            binding.text.text = it // 이건 viewBinding으로 쓰면 조건이 맞지 않다.
//        })
    }
}