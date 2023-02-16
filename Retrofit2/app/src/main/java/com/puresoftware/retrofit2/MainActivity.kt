// https://www.youtube.com/watch?v=UnfhKoYLQpI
// editText에는 etc 또는 btc로 검색하기
// 해당 Http는 비트 거래소인 https://apidocs.bithumb.com/reference/%ED%98%84%EC%9E%AC%EA%B0%80-%EC%A0%95%EB%B3%B4-%EC%A1%B0%ED%9A%8C-all

package com.puresoftware.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var coinEdit: EditText
    lateinit var resultText: TextView
    lateinit var searchBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coinEdit = findViewById(R.id.coinEdit)
        resultText = findViewById(R.id.resultText)
        searchBtn = findViewById(R.id.searchBtn)

        searchBtn.setOnClickListener {

            resultText.text = "" // text 초기화

            apiRequest() // method
        }
    }

    fun apiRequest() {

        // Retrofit 객체
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.bithumb.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        // Service 객체(우리가 만들었던 Interface)
        val apiService: ApiService =
            retrofit.create(ApiService::class.java) // interface인데 왜 class로 지정되는 지 이해가 안되는 군요. new 인가요?

        // Call 객체(data class고, status값과 DataModel이 저장된 하나의 data 객체를 의미함)
        val coinNum = coinEdit.text.toString()
            .uppercase() // 일단 EditText에 있는 내용을 가져온다고 함, Upper는 대문자만 인식하는 것인가?

        val tickerCall = apiService.getCoinTicker(
            coinNum,
            "KRW"
        ) // Path에 적힌 것은 그냥 주석같은 개념이지만, 그 주석이 Http하고 일치해야는듯.

        // netWork 통신
        tickerCall.enqueue(object :
            Callback<Ticker> { // Retrofit 전용 Callback이므로 Android CallBack이 X
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<Ticker>, response: Response<Ticker>) {
                val tickerInfo = response.body() // Json으로 받아오는 Ticker(정보)? 이게 Json에서 이미 변환되서 오는건가?
                resultText.append("status: ${tickerInfo?.status} \n")
                resultText.append("closing_price: ${tickerInfo?.data?.closing_price} \n")
                resultText.append("opening_price: ${tickerInfo?.data?.opening_price} \n")
                resultText.append("max_price: ${tickerInfo?.data?.max_price} \n")
                resultText.append("min_price: ${tickerInfo?.data?.min_price} \n")

                Log.i("TAG", "Ticker는 객체입니다: " + tickerInfo.toString())
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<Ticker>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}