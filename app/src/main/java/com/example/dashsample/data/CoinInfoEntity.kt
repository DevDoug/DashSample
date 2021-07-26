package com.example.dashsample.data

import com.google.gson.annotations.SerializedName

data class CoinInfoEntity(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rate")
    val rate: Float,
)
