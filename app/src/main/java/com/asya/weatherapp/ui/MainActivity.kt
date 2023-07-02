package com.asya.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.asya.weatherapp.R
import com.asya.weatherapp.databinding.ActivityMainBinding
import com.asya.weatherapp.databinding.CustomToolbarBinding
import com.asya.weatherapp.ui.favoritesWeather.WeatherDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var toolbar: CustomToolbarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WeatherDatabase.initDatabase(this)

        toolbar = binding.toolbar.apply {
            titleTextView.text = "Current Weather"
            backButton.visibility = View.INVISIBLE
            titleTextView.visibility = View.VISIBLE
            favbutton.visibility = View.INVISIBLE
        }


        val navController =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()
        navController?.let {
            binding.bottomNavigationView.setupWithNavController(navController)
        }
    }
}
