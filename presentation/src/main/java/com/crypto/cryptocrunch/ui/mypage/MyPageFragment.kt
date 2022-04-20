package com.crypto.cryptocrunch.ui.mypage

import android.os.Bundle
import android.view.View
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.base.BaseFragment
import com.crypto.cryptocrunch.databinding.FragmentHomeBinding


class MyPageFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_my_page

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialSetting()
    }

    override fun initObserver() {}

    fun initialSetting() {

    }



}