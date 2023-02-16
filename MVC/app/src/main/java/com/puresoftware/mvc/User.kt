package com.puresoftware.mvc

// MVC중 Model
data class User(var userName: String? = null, var password: String? = null) {

    fun login(userName: String?, password: String?): Boolean {

        // 현업 로직
        // 매개변수들의 Data와 SecretData와 서로 일치하면 그 Data들을 Local변수에 저장.
        if (userName == secretName && password == secretWord) {
            this.userName = userName
            this.password = password

            return true // 정상적임을 의미한다.
        }
        return false // 비정상적임을 의미한다.
    }

    // 로그인 정보 static
    companion object {
        const val secretName = "user"
        const val secretWord = "1234"

        // Java로 표현하면
        // public static final String secretName ="user"
        // public static final String secretWord = "1234"
    }
}