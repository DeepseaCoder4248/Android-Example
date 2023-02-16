package com.puresoftware.viewmodel2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.puresoftware.viewmodel2.databinding.ActivityMainBinding

// https://todaycode.tistory.com/33
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // 이미 viewBinding이 되어버림.
    private lateinit var userViewModel: UserViewModel // 우리가 쓸 ViewModel

    //log
    val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // binding

        //log
        Log.i(TAG, "Oncreated")

        // viewModel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java) // instance
        binding.user = userViewModel // activity_main.xml의 data쪽에서 호출된 name이다.

        // 위에 주석 달은 걸 줄이면 이거임. 데이터를 가져옴.
        // 동작을 받는 역할로 추정
        userViewModel.height.observe(this, Observer {
            binding.textViewHeight.text = it.toString()

            //log
            userViewModel.dataLog()
            Log.i(TAG, "onCreate 후 viewModel 작동함.")
        })

        // ViewModel을 기법으로 작동되는 원리
        // 동작을 주는 역할로 추정
        binding.edt.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userViewModel.setData(count) // 보아하니 set은 따로 만들어줘야 하나 보다.

                userViewModel.dataLog()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    override fun onDestroy() {
        Log.i(TAG, "Destroyed")
        super.onDestroy()
    }
}
// 원리 정리
// 1.xml에서 onClick, OnTextChanged OnMethod에서 동작을 판별한다.
// 2.동작을 구분하면, 내가 지정해둔 android:onClick="@{()->user.height}"이라는 구조로 viewModel의 method로 이동한다.
// 3.viewModel의 height는 값이 변하지 않는 상태로 _height -> height로 값을 가져온다.
// 4.height의 변수가 작동되는것을 확인하는 것은 MainActivity의 height.observe다.
// 5.set은 다른 원리로 접근을 해야 한다.