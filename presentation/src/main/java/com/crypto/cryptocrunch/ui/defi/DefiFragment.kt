package com.crypto.cryptocrunch.ui.defi

import android.os.Bundle
import android.view.View
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.base.BaseFragment
import com.crypto.cryptocrunch.databinding.FragmentDefiBinding
import com.crypto.cryptocrunch.ui.home.DefiViewModel


class DefiFragment : BaseFragment<FragmentDefiBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_defi

    private val viewModel = DefiViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm = viewModel
            tvHello.text = "DEFI Fragment MVVM"
        }

    }

    override fun initObserver() {}

    fun initialSetting() {

    }

}