package com.asya.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.asya.weatherapp.R
import com.asya.weatherapp.databinding.ActivityMainBinding
import com.asya.weatherapp.databinding.CustomToolbarBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var toolbar: CustomToolbarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = binding.toolbar

        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)?.findNavController()
        navController?.let {
            binding.bottomNavigationView.setupWithNavController(navController)
        }
    }
}
