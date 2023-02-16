package com.puresoftware.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


// MVC중 Controller. View와 Model을 이어줄 중심부
class MainActivity : AppCompatActivity() {

    private lateinit var user: User // Model
    lateinit var etUserName: EditText
    lateinit var etPassword: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)// 확실한 개념을 위해 ViewBinding을 하지 않음.

        user = User() // Model Class 초기화

        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        loginBtn = findViewById(R.id.loginBtn)

        // 프레젠테이션 로직
        loginBtn.setOnClickListener {
            val isLoginSuccessful = user.login(
                etUserName.text.toString(),
                etPassword.text.toString(),
            )

            if (isLoginSuccessful) {
                Toast.makeText(this, "${user.userName} Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
// 원리
// 구조는 Model, Controller, View
// Model Class는 여러 정보가 담긴 객체
// View는 layout.xml
// Controller는 Activity 또는 Fragment 또는 Adapter등
// 결론은 Activity에서 View의 Method로 Model을 연결
