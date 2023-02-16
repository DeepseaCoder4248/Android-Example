package com.puresoftware.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.puresoftware.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var myNumberViewModel: MyNumberViewModel

    val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // instance
        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        // LiveData Callback
        myNumberViewModel.currentValue.observe(this, Observer {
            viewBinding.numberTextview.text = it.toString() // 여기서 text값이 바뀌면 callback됨.
        })
    }
}