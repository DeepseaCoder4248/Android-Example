package com.puresoftware.retrofit2_1

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitService {

    // GET
    @GET("posts") // 주소
    fun getPosts(): retrofit2.Call<List<PostResult>>

    // Path
    @GET("posts/{id}") // 주소
    fun getPost(@Path("id") id: String?): retrofit2.Call<List<PostResult>>// 메소드{와 일치해야함}

    // Query
    @GET("posts")
    fun getPostsQuery(@Query("userId") userId: String?): retrofit2.Call<List<PostResult>>// return은 결국 PostResult를 담은 List

    // 다중 Query
    @GET("posts")
    fun getPostsMultiQuery(@Query("userId") userId: String?, @Query("id") id: String?): retrofit2.Call<List<PostResult>>

    // POST
    @POST("posts")
    fun setPostBody(@Body post:PostResult):retrofit2.Call<PostResult> // 항상 type지정은 같다.

    // Field Post
    @FormUrlEncoded
    @POST("posts")
    fun setPostField(
        @Field("userId") userId: String?,
        @Field("title") title: String?,
        @Field("body") body: String
    ): retrofit2.Call<PostResult>

}