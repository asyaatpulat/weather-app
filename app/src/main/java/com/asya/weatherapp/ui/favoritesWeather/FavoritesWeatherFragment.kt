package com.asya.weatherapp.ui.favoritesWeather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asya.weatherapp.R
import com.asya.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.asya.weatherapp.databinding.FragmentFavoritesWeatherBinding

class FavoritesWeatherFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFavoritesWeatherBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesWeatherBinding.inflate(layoutInflater)
        return binding.root
    }
}
