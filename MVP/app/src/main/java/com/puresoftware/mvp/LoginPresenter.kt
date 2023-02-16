package com.puresoftware.mvp

// 규칙 라인
// MVP중 Presenter
interface LoginPresenter {

    // LoginPresenterImpl class에 쓸 변수인 Model
    val user: User

    // LoginPresenterImpl class에 쓸 규칙인 Login
    fun login()
}