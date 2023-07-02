package com.asya.weatherapp.ui.weatherDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.asya.weatherapp.R
import com.asya.weatherapp.databinding.WeatherDetailFragmentBinding
import com.asya.weatherapp.ui.MainActivity
import com.asya.weatherapp.ui.favoritesWeather.FavoriteCityEntity
import com.asya.weatherapp.ui.favoritesWeather.WeatherDatabase
import kotlinx.coroutines.*


class WeatherDetailFragment : Fragment() {
    private val viewModel = WeatherDetailViewModel()
    private lateinit var binding: WeatherDetailFragmentBinding
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    private val args: WeatherDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WeatherDetailFragmentBinding.inflate(layoutInflater)
        uiScope.launch(Dispatchers.IO) {
            viewModel.getCityDetail(cityName = args.cityName)
        }
        binding.cityName.text = args.cityName


        viewModel.cityDetailData.observe(viewLifecycleOwner) { response ->
            binding.humidityDegree.text = response.main?.humidity.toString()
            binding.degree.text = response.main?.temp.toString()
            binding.windSpeedDegree.text = response.wind?.speed.toString()
            binding.windDegree2.text = response.wind?.deg.toString()
            binding.icon.load("https://openweathermap.org/img/wn/" + response.weather?.get(0)?.icon + "@2x.png")
        }

        val toolbar = (activity as MainActivity).toolbar?.apply {
            titleTextView.text = "Weather Detail"
            titleTextView.visibility = View.VISIBLE
            backButton.visibility = View.VISIBLE
            favbutton.visibility = View.VISIBLE
            backButton.setOnClickListener {
                findNavController().popBackStack()
                backButton.visibility = View.GONE
                favbutton.visibility = View.GONE
                titleTextView.text = "Current Weather"
            }
        }

        toolbar?.favbutton?.setOnClickListener {
            val result = WeatherDatabase
                .instance
                .favoriteCityListDao()
                .insert(
                    *listOf(
                        FavoriteCityEntity(cityName = args.cityName)
                    ).toTypedArray()
                )
            if (result.isNotEmpty()) {
                toolbar.favbutton.background = context?.let { context ->
                    ContextCompat.getDrawable(context, R.drawable.ic_favorite)
                }
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        uiScope.cancel()
        job.cancel()
    }

}