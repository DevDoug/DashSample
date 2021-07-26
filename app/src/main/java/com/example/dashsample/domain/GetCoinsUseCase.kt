package com.example.dashsample.domain

import com.example.dashsample.data.CoinInfoEntity
import com.example.dashsample.data.CoinRepository
import com.example.dashsample.presentation.entity.CoinDisplayEntity
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class GetCoinsUseCase @Inject constructor(private val dataSource : CoinRepository) {
    suspend fun getCoinListWithBaseCurrency(baseCurrency: String) : Flow<ArrayList<CoinDisplayEntity>> {
        return dataSource.getCoins(baseCurrency).map { coinData ->
                coinData.map {  item -> CoinDisplayEntity(item.name, item.rate) } as ArrayList<CoinDisplayEntity>
            }
    }
}