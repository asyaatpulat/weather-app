package com.asya.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.asya.weatherapp.R
import com.asya.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()

        navController?.let {
            binding.bottomNavigationView.setupWithNavController(navController)
        }
        supportActionBar?.apply {
            setCustomView(R.layout.custom_toolbar)
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        }
        //val textView = supportActionBar!!.customView.findViewById<TextView>(com.asya.weatherapp.R.id.toolbar)

    }
}
