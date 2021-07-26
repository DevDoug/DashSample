package com.example.dashsample.network

import com.example.dashsample.data.CoinDataEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface CoinApi {
    @GET("rates/")
    suspend fun getCoins(@Query("baseCurrency") baseCurrency:String): Response<CoinDataEntity>
}