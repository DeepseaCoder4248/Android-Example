package com.puresoftware.viewmodel2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    val TAG = UserViewModel::class.java.simpleName // TAG

    // 변경이 가능한 마스터 값. Save(필수!)
    private var _height = MutableLiveData<Int>()

    // 변경이 불가능한 받아오는 값. Get(필수!)
    val height: LiveData<Int>
        get() = _height

    // init로 설정하는 초기값.(필수!)
    init {
        _height.value = 170
    }

    // 다른 방법으로 Set(필수!)
    fun setData(count: Int) {
        _height.value = count
    }

    // 값을 확인하기 위한 Log
    fun dataLog() {
        Log.i(TAG, "ViewModel의 _Height는 ${_height.value}")
        Log.i(TAG, "ViewModel의 Height는 ${height.value}")
    }
}