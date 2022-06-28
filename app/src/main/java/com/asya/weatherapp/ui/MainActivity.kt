package com.asya.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.asya.weatherapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.asya.weatherapp.databinding.ActivityMainBinding
import com.asya.weatherapp.databinding.CustomToolbarBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.current_weather_fragment, R.id.favorites_weather_fragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        toolbar = binding.toolbar
        toolbar?.titleTextView?.text = "Current Weather"
        toolbar?.backButton?.visibility = View.INVISIBLE
        toolbar?.titleTextView?.visibility = View.VISIBLE
        toolbar?.favbutton?.visibility = View.INVISIBLE


        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()
        navController?.let {
            binding.bottomNavigationView.setupWithNavController(navController)
        }
    }
}