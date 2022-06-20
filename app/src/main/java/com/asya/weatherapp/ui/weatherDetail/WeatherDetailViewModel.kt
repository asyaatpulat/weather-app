package com.asya.weatherapp.ui.weatherDetail

import androidx.lifecycle.MutableLiveData
import com.asya.weatherapp.data.remote.api.RetrofitClient
import com.asya.weatherapp.data.remote.model.CurrentWeatherResponse

class WeatherDetailViewModel {
    private val weatherAPI = RetrofitClient.weatherAPI

    val weatherData = MutableLiveData<CurrentWeatherResponse>()
    val weatherError = MutableLiveData<Boolean>()
    val weatherLoad = MutableLiveData<Boolean>()


    suspend fun refreshData(cityName: String) {
        getDataFromAPI(cityName)
    }

    private suspend fun getDataFromAPI(cityName: String) {
        weatherLoad.value = true
        val response = weatherAPI.userSearch(cityName)
        response?.let { weatherData.postValue(it) }
    }
}
