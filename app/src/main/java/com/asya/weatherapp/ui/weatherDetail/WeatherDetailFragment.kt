package com.asya.weatherapp.ui.weatherDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.asya.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.asya.weatherapp.databinding.WeatherDetailFragmentBinding
import com.asya.weatherapp.ui.currentWeather.CurrentWeatherViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

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
        val cityName = args.cityName
        binding.textView3.text = cityName
        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        uiScope.cancel()
        job.cancel()
    }

}