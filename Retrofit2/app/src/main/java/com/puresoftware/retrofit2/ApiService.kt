package com.puresoftware.retrofit2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Currency

interface ApiService {

    @GET("public/ticker/{order_currency}_{payment_currency}")
    fun getCoinTicker(@Path("order_currency") orderCurrency: String, @Path("payment_currency")paymentCurrency:String): Call<Ticker>
    // @GET에는 DB를 연결할 때, 이 이름으로 등록되어 있는 통신쪽의 Mesthod에서(Controller - Mapper)다.
    // @GET의 저 내용들은 Http 주소이며, {이 안의 이름과 Path의 이름이 일치해야 한다.}
    // Test 결과, {}이건 Path의 Parameter의 역할을 한다.

}