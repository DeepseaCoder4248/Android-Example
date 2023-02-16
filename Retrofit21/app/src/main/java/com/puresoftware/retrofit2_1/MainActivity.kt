package com.puresoftware.retrofit2_1

// https://jaejong.tistory.com/33
// https://jaejong.tistory.com/38?category=873924
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instance
        var retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
        var retrofitService: RetrofitService = retrofit.create(RetrofitService::class.java)

        // 일반적인 get
        var call = retrofitService.getPosts()
        call.enqueue(object :Callback<List<PostResult>>{

            override fun onResponse(
                call: Call<List<PostResult>>, response: Response<List<PostResult>>) {
                Log.i("TAG","성공")
            }

            override fun onFailure(call: Call<List<PostResult>>, t: Throwable) {
                Log.i("TAG","실패")
            }
        })

        // path get
        var call2 = retrofitService.getPost("5")
        call2.enqueue(object :Callback<List<PostResult>>{

            override fun onResponse(
                call: Call<List<PostResult>>, response: Response<List<PostResult>>) {
                Log.i("TAG","성공")
            }
            override fun onFailure(call: Call<List<PostResult>>, t: Throwable) {
                Log.i("TAG","실패")
            }

        })

        // Query get
        var call3 = retrofitService.getPostsQuery("10")
        call3.enqueue(object :Callback<List<PostResult>>{

            override fun onResponse(
                call: Call<List<PostResult>>, response: Response<List<PostResult>>) {
                Log.i("TAG","성공")
            }

            override fun onFailure(call: Call<List<PostResult>>, t: Throwable) {
                Log.i("TAG","실패")
            }
        })

        // MultiQuery
        var call4 = retrofitService.getPostsMultiQuery("10","96")
        call4.enqueue(object:Callback<List<PostResult>>{

            override fun onResponse(
                call: Call<List<PostResult>>, response: Response<List<PostResult>>) {
                Log.i("TAG","성공")
            }

            override fun onFailure(call: Call<List<PostResult>>, t: Throwable) {
                Log.i("TAG","실패")
            }
        })

        // post
        val post = PostResult(1000,"test title","test body")
        var call5 = retrofitService.setPostBody(post)

//        var call6
        // git test
        // git test!!!!
        // git commit test!


    }
}