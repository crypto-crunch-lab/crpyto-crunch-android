package com.crypto.cryptocrunch.ui.mypage

import android.os.Bundle
import android.view.View
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.base.BaseFragment
import com.crypto.cryptocrunch.databinding.FragmentHomeBinding
import com.crypto.cryptocrunch.databinding.FragmentMyPageBinding


class MyPageFragment : BaseFragment<FragmentMyPageBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_my_page

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initObserver() {}

}