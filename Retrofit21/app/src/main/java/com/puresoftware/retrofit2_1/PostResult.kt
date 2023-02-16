package com.puresoftware.retrofit2_1

import com.google.gson.annotations.SerializedName


class PostResult(userId:Int,string:String,bodyValue:String) {

    @SerializedName("userId")
    private val userId = 0

    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함
    @SerializedName("id")
    private val id = 0

    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑시켜줌
    private val title: String? = null

    @SerializedName("body")
    private val bodyValue: String? = null

    override fun toString(): String {
        return "PostResult{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", bodyValue='" + bodyValue + '\'' +
                '}';
    }
}