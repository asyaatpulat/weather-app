package com.asya.weatherapp.ui.weatherDetail

import androidx.lifecycle.MutableLiveData
import com.asya.weatherapp.data.remote.api.RetrofitClient
import com.asya.weatherapp.data.remote.model.CurrentWeatherResponse

class WeatherDetailViewModel {

    private val weatherAPI = RetrofitClient.weatherAPI
    val cityDetailData = MutableLiveData<CurrentWeatherResponse>()

    suspend fun refreshData(cityName: String) {
        getCityDetail(cityName)
    }

    suspend fun getCityDetail(cityName: String) {
        val response = weatherAPI.userSearch(cityName)
        response?.let { cityDetailData.postValue(it) }
    }

}
