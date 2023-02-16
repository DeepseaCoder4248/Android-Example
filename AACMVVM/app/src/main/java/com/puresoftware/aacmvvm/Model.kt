package com.puresoftware.aacmvvm

import android.util.Log

// Model
class Model(val name: String, val age: String, val gender: String) {

    // Model의 정보 가져오기
    fun getModelInfo(): String {
        return "이름은 ${name}, 나이는 ${age}, 성별은 ${gender} "
    }
}