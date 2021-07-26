package com.example.dashsample.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.dashsample.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_header_fragment.*

class MainHeaderFragment : Fragment() {

    private val viewModel: CoinHomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_header_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        change_button.setOnClickListener { (activity as MainActivity).showCurrencyBaseList() }
        viewModel.baseCurrency.observe(viewLifecycleOwner, {
            current_base_currency.text = it
        })
    }
}