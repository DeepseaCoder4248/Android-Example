package com.puresoftware.ch8_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.puresoftware.ch8_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    var initTime = 0L // 뒤로가기 버튼을 누른 시각을 저장
    var pauseTime = 0L // 멈춘 시각을 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater) // 액티비티명으로 바인딩
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()

            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false

            Log.i(TAG, "startButton result")
            Log.i(TAG, "binding.chronometer.base = ${binding.chronometer.base}")
            Log.i(TAG, "pauseTime = ${pauseTime} ")
            Log.i(TAG, "-----")
        }

        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime() // ???
            binding.chronometer.stop()

            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = true

            Log.i(TAG, "pauseButton result")
            Log.i(TAG, "binding.chronometer.base(처음누르고 시작한 시각) = ${binding.chronometer.base}")
            Log.i(TAG, "SystemClock.elapsedRealtime(내가 누른 시각) = ${SystemClock.elapsedRealtime()}")
            Log.i(TAG, "pauseTime = ${pauseTime} ")
            Log.i(TAG, "-----")
        }

        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = false
            binding.startButton.isEnabled = true
        }
    }
}