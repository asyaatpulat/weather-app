package com.asya.weatherapp.ui.currentWeather

import androidx.lifecycle.MutableLiveData
import com.asya.weatherapp.data.remote.api.RetrofitClient
import com.asya.weatherapp.data.remote.model.CurrentWeatherResponse


class CurrentWeatherViewModel {
    private val retrofitClient = RetrofitClient()
    val weatherData = MutableLiveData<CurrentWeatherResponse?>()

    suspend fun getDataFromAPI(query: String) {
        val data = retrofitClient.getDataService("izmir")
        weatherData.postValue(data)
    }


}