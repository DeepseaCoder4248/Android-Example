package com.puresoftware.mvp

interface MvpLoginView {
    val userName: String?
    val password: String?

    fun onLoginResult(isLoginSuccess: Boolean?)

    // 개인개발 로그
    fun Log(): String {
        var result = userName + "," + password
        return result
    }
}