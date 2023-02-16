package com.puresoftware.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.puresoftware.livedata.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

// https://stickode.tistory.com/194
class MainActivity : AppCompatActivity() {

    var liveText: MutableLiveData<String> = MutableLiveData() // 추상 class라서 반드시 호출이 필요함.
    var count = 0 // button을 누르면 증가하는 숫자
    val TAG: String = MainActivity::class.java.simpleName // TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBinding = ActivityMainBinding.inflate(layoutInflater) // viewBinding
        setContentView(viewBinding.root)

        liveText.observe(this, Observer {
// text_test.text = it // gradle의 kotlin_extension으로 호출한 것.
// viewBinding.btnChange = it // LiveData의<값>이 결정해줌.

            viewBinding.textTest.text = it

            Log.i(TAG, "해당 observe가 실행됨.")
        }) // owner는 생명주기를 담당하는 클래스를, 두번째는 값의 변경을 감지하고 작동하는 Observer Callback

        // button을 누르면 count가 증가하면서 그 값이 liveText에 Callback
        // 중요한건 Activity의 생명주기가 Destory되었다가 다시 Start가 될 때 값이 유지되냐는 것.
        viewBinding.btnChange.setOnClickListener {
            liveText.value = "Hello World ${++count}"

            Log.i(TAG, "현재 count 값은 ${count}")
        }
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()
    }


}