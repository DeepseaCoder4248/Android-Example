package com.puresoftware.mvp

import android.util.Log

// 로직 라인
// MVP중 Presenter
class LoginPresenterImpl(private val mvpLoginView: MvpLoginView) : LoginPresenter {

    // LoginPresenter에서 가져온 Interface 변수
    override val user: User
        get() = User()

    // LoginPresenter에서 가져온 Interface 메소드
    override fun login() {

        val userName = mvpLoginView.userName.toString() // 이름 변수 대입
        val password = mvpLoginView.password.toString() // 비번 변수 대입
        val isLoginSuccessful: Boolean = user.login(userName, password) // id pw true false
        mvpLoginView.onLoginResult(isLoginSuccessful) // 여기서 MvPLogin > MainActivity.result로 가는 듯.

        Log.i("TAG", "LoginPresenterImpl의 login 실행됨.")
        Log.i(
            "TAG",
            "LoginPresenterImpl의 현재 user는 ${user.userName}과 ${user.password}고 상태는 ${isLoginSuccessful}"
        )
    }
}