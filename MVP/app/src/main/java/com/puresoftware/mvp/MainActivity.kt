package com.puresoftware.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.puresoftware.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MvpLoginView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginPresenterImpl: LoginPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginPresenterImpl = LoginPresenterImpl(this) // Impl에서 로직점검?

        // 버튼을 누르면 Login 시도
        binding.included.loginBtn.setOnClickListener {
            loginPresenterImpl.login()

            Log.i("TAG", "Main의 LoginPresenterImpl 실행")
            Log.i("TAG", "Main의 MvpLoginView.this Data는 ${this.Log()}")
        }
    }

    override val userName: String
        get() = binding.included.etUserName.text.toString()

    override val password: String?
        get() = binding.included.etPassword.text.toString()

    override fun onLoginResult(isLoginSuccess: Boolean?) {
        if (isLoginSuccess == true) {
            Toast.makeText(this@MainActivity, "$userName Login Successful", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(this@MainActivity, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}