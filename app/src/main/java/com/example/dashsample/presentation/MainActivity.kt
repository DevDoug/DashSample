package com.example.dashsample.presentation

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dashsample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var homeViewModel: CoinHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel = ViewModelProvider(this).get(CoinHomeViewModel::class.java)
        homeViewModel.baseCurrency.value = "BTC"
    }

    fun showCurrencyBaseList() {

        val builder: AlertDialog.Builder? = let {
            AlertDialog.Builder(it)
        }
        builder?.setTitle(R.string.dialog_title)
        builder?.setItems(
            R.array.base_array
        ) { _, which ->
            // The 'which' argument contains the index position
            // of the selected item
            homeViewModel.baseCurrency.value =
                getResources().getStringArray(R.array.base_array).get(which).toString()
                    .substringAfter("(").dropLast(1)

            //Refresh coin list based on new base currency
            homeViewModel.fetchCoinJob.cancel()
            homeViewModel.getCoins()
        }
        val dialog: AlertDialog? = builder?.create()
        dialog?.show()
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.getCoins()
    }
}