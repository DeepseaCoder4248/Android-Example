package com.puresoftware.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyNumberViewModel : ViewModel() { // androidx.lifecycle의 viewModel이다. Koin이 아님.

    // TAG
    val TAG: String = MyNumberViewModel::class.java.simpleName

    // 내부에서 설정하는 자료형은 Mutable로 변경가능하도록 설정한다.
    private val _currentValue = MutableLiveData<Int>() // LifeCycle의 상태를 관찰하는 것. Int값으로 간다.

    // 뷰모델이 생성될대 초기값 설정해준다
    val currentValue: LiveData<Int>
        get() = _currentValue // get() =은 getter를 쓴다는 의미고, set() =은 setter를 쓴다.

    // 매개변수가 없어서 주입이 안되고, 반환되는 값이 없다.
    init {
        //LiveData로 맵핑이 되어있을때 값을 수정하려면 value를 이용한다.
        //LivaData로는 값 수정이 불가능 하지만 MutableLiveData로 초기화 했기 때문에 수정이 가능하다.
        _currentValue.value = 0

        Log.i(TAG, "init의 currentValue.value는 ${_currentValue.value}")
    }

//    fun updateValue(actionType: ActionType, input: Int){
//        when(actionType){
//            ActionType.PLUS ->
//                _currentValue.value = _currentValue.value?.plus(input)
//            ActionType.MINUS ->
//                _currentValue.value = _currentValue.value?.minus(input)
//        }
//    }
}