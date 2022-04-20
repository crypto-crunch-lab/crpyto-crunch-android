package com.crypto.cryptocrunch.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.base.BaseActivity
import com.crypto.cryptocrunch.databinding.ActivityMainBinding
import com.crypto.cryptocrunch.ui.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResId: Int
        get() = R.layout.activity_main

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBottomNavigation()
        binding.mainViewModel = mainViewModel
    }

    override fun initObserver() {}

    private fun setBottomNavigation() {
        val navController = supportFragmentManager.findFragmentById(R.id.navigation_fragment)
        val bottomNav = binding.bottomNavi

        bottomNav.setupWithNavController(navController!!.findNavController())
    }
}