package com.asya.weatherapp.data.remote.api

import com.asya.weatherapp.Configs
import com.asya.weatherapp.data.remote.model.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("weather")
    suspend fun userSearch(
        @Query("q") query: String?,
        @Query("appid") appId: String? = Configs.Network.APP_ID
    ): CurrentWeatherResponse?
}