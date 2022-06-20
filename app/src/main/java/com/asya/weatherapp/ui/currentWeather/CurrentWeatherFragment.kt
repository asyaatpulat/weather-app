package com.asya.weatherapp.ui.currentWeather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asya.weatherapp.CityList
import com.asya.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.asya.weatherapp.ui.favoritesWeather.adapter.CityListAdapter
import com.asya.weatherapp.ui.favoritesWeather.model.CityModel
import kotlinx.coroutines.*

class CurrentWeatherFragment : Fragment() {
    private val viewModel = CurrentWeatherViewModel()
    private lateinit var binding: FragmentCurrentWeatherBinding
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCurrentWeatherBinding.inflate(layoutInflater)
        binding.recyclerview
            .apply {
                this.layoutManager = LinearLayoutManager(
                    context, LinearLayoutManager.VERTICAL, false
                )
                this.adapter = CityListAdapter(
                    cityList = CityList.getCityList() as ArrayList<CityModel>,
                    clickHandler = { cityName ->
                        val action = CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToWeatherDetailFragment(cityName)
                        findNavController().navigate(action)
                    }
                )
            }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        uiScope.cancel()
        job.cancel()
    }
}
