package com.asya.weatherapp.ui.favoritesWeather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asya.weatherapp.R
import com.asya.weatherapp.databinding.CustomToolbarBinding
import com.asya.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.asya.weatherapp.databinding.FragmentFavoritesWeatherBinding
import com.asya.weatherapp.ui.MainActivity

class FavoritesWeatherFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesWeatherBinding
    var toolbar: CustomToolbarBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFavoritesWeatherBinding.inflate(layoutInflater)
        val toolbar = (activity as MainActivity).toolbar
        toolbar?.titleTextView?.text = "Favorites"
        toolbar?.backButton?.visibility = View.INVISIBLE
        toolbar?.titleTextView?.visibility = View.VISIBLE
        toolbar?.favbutton?.visibility = View.INVISIBLE


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites_weather, container, false)
    }
}
