package com.asya.weatherapp.ui.currentWeather

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.asya.weatherapp.databinding.FragmentCurrentWeatherBinding
import kotlinx.coroutines.*

class CurrentWeatherFragment : Fragment() {
    private val viewModel = CurrentWeatherViewModel()
    private lateinit var binding: FragmentCurrentWeatherBinding

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCurrentWeatherBinding.inflate(layoutInflater)

        uiScope.launch(Dispatchers.IO) {
            val data = viewModel.getDataFromAPI("")
            println("test")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        uiScope.cancel()
        job.cancel()
    }
}
