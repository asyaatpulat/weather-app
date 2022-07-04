package com.asya.weatherapp.ui.favoritesWeather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asya.weatherapp.databinding.CustomToolbarBinding
import com.asya.weatherapp.databinding.FragmentFavoritesWeatherBinding
import com.asya.weatherapp.ui.MainActivity

class FavoritesWeatherFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesWeatherBinding
    var toolbar: CustomToolbarBinding? = null
    private lateinit var cityListDatabase : WeatherDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFavoritesWeatherBinding.inflate(layoutInflater)
        val toolbar = (activity as MainActivity).toolbar?.
        apply {
            titleTextView.text = "Favorites"
            backButton.visibility = View.INVISIBLE
            titleTextView.visibility = View.VISIBLE
            favbutton.visibility = View.INVISIBLE
        }

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
