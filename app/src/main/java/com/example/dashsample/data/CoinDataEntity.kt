package com.example.dashsample.data

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class CoinDataEntity(
    @SerializedName("data")
    val coinList: ArrayList<CoinInfoEntity>
)
