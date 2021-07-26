package com.example.dashsample.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dashsample.domain.GetCoinsUseCase
import com.example.dashsample.presentation.entity.CoinDisplayEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinHomeViewModel @Inject constructor(private val getCoinsListUseCase: GetCoinsUseCase)  : ViewModel() {

    private val _coinList = MutableLiveData<ArrayList<CoinDisplayEntity>>()
    val coinList = _coinList

    private val _baseCurrency = MutableLiveData<String>()
    val baseCurrency = _baseCurrency

    lateinit var fetchCoinJob : Job

    fun getCoins() {
        fetchCoinJob = viewModelScope.launch {
            baseCurrency.value?.let {
                getCoinsListUseCase.getCoinListWithBaseCurrency(it).collect {
                    _coinList.value = it
                }
            }
        }
    }
}