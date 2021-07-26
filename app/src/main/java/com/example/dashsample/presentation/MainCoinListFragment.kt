package com.example.dashsample.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dashsample.R
import com.example.dashsample.data.CoinInfoEntity
import com.example.dashsample.presentation.entity.CoinDisplayEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_coin_list_fragment.*

class MainCoinListFragment : Fragment() {

    private val viewModel: CoinHomeViewModel by activityViewModels()
    private lateinit var coinAdapter: CoinAdapter
    var fakeCoins : ArrayList<CoinDisplayEntity> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_coin_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        coinAdapter = CoinAdapter(fakeCoins)
        coin_list_main.adapter = coinAdapter
        coin_list_main.layoutManager = LinearLayoutManager(activity)

        viewModel.coinList.observe(viewLifecycleOwner, { result ->
            coinAdapter.infoSet = result
            coinAdapter.notifyDataSetChanged()
        })
    }
}