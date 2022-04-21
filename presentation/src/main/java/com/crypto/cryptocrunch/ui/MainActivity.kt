package com.crypto.cryptocrunch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
  private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        val navController = supportFragmentManager.findFragmentById(R.id.navigation_fragment) as NavHostFragment
        binding.bottomNavi.setupWithNavController(navController.findNavController())
    }
}