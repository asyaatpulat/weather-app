package com.asya.weatherapp.ui.weatherDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.asya.weatherapp.databinding.WeatherDetailFragmentBinding
import com.asya.weatherapp.ui.MainActivity
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
        val toolbar = (activity as MainActivity).toolbar
        toolbar?.titleTextView?.text = "Weather Detail"
        toolbar?.titleTextView?.visibility = View.VISIBLE
        toolbar?.backButton?.visibility = View.VISIBLE
        toolbar?.favbutton?.visibility = View.VISIBLE
        toolbar?.backButton?.setOnClickListener {
            findNavController().popBackStack()
            toolbar.backButton.visibility = View.GONE
            toolbar.favbutton.visibility = View.GONE
            toolbar?.titleTextView?.text = "Current Weather"

        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        uiScope.cancel()
        job.cancel()
    }

}