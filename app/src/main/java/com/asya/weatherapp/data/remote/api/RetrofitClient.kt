package com.asya.weatherapp.data.remote.api

import com.asya.weatherapp.Configs
import com.asya.weatherapp.data.remote.model.CurrentWeatherResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitClient {
   val moshi = Moshi.Builder()
      .add(KotlinJsonAdapterFactory())
      .build()

   val api = Retrofit.Builder()
      .baseUrl(Configs.Network.API_BASE_URL)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .build()
      .create(WeatherAPI::class.java)

   suspend fun getDataService(query:String): CurrentWeatherResponse? {
      return api.userSearch(query)
   }
}