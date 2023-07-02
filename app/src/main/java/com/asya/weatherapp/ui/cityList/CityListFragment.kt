package com.asya.weatherapp.ui.cityList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.asya.weatherapp.CityList
import com.asya.weatherapp.databinding.FragmentCityListBinding
import com.asya.weatherapp.ui.cityList.adapter.CityListAdapter
import com.asya.weatherapp.ui.cityList.model.CityModel
import kotlinx.coroutines.*

class CityListFragment : Fragment() {
    private val viewModel = CityListViewModel()
    private lateinit var binding : FragmentCityListBinding
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCityListBinding.inflate(layoutInflater)
        binding.recyclerview
            .apply {
                this.layoutManager = LinearLayoutManager(
                    context, LinearLayoutManager.VERTICAL, false
                )
                this.adapter = CityListAdapter(
                    cityList = CityList.getCityList() as ArrayList<CityModel>,
                    clickHandler = { cityName ->
                        val action = CityListFragmentDirections.actionCurrentWeatherFragmentToWeatherDetailFragment(cityName)
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
