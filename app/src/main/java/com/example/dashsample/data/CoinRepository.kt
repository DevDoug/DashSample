package com.example.dashsample.data

import com.example.dashsample.network.CoinApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CoinRepository @Inject constructor(private val coinApi: CoinApi) {
    private val refreshIntervalMs: Long = 5000
    suspend fun getCoins(baseCurrency : String) : Flow<ArrayList<CoinInfoEntity>> {
        return flow {
            while(true) {
                /* Get from remote repo only in this sample however this is where we would add logic
                * for say getting from local db when remote service is unavailable*/
                val coinResponse  = coinApi.getCoins(baseCurrency)
                if(coinResponse.isSuccessful){
                    //return response coin list
                    coinResponse.body()?.coinList?.let { emit(it) }
                } else {
                    //return flow of empty
                    emit(ArrayList<CoinInfoEntity>())
                }
                kotlinx.coroutines.delay(refreshIntervalMs)
            }
        }.flowOn(Dispatchers.IO)
    }
}