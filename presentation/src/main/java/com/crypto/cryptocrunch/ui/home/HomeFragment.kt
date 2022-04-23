package com.crypto.cryptocrunch.ui.home

import android.os.Bundle
import android.view.View
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.base.BaseFragment
import com.crypto.cryptocrunch.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_home

    private val viewModel = DefiViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initObserver() {}


}