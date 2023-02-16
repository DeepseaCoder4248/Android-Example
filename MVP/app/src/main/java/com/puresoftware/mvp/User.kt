package com.puresoftware.mvp

// MVP중 Model
data class User(var userName: String? = null, var password: String? = null) {

    // Activity에서 Login할 것.
    fun login(userName: String?, password: String?): Boolean {
        if (userName == secretName && password == secretWord) {
            this.userName = userName
            this.password = password
            return true
        }
        return false
    }

    // 1회용 생성기
    companion object {
        const val secretName = "user"
        const val secretWord = "1234"
    }
}