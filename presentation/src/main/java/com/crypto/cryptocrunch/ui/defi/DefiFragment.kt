package com.crypto.cryptocrunch.ui.defi

import android.os.Bundle
import android.view.View
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.base.BaseFragment
import com.crypto.cryptocrunch.databinding.FragmentHomeBinding
import com.crypto.cryptocrunch.ui.home.DefiViewModel


class DefiFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_defi

    private val viewModel = DefiViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun initObserver() {}

    fun initialSetting() {

    }

}