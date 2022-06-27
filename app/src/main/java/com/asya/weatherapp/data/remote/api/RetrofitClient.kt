package com.asya.weatherapp.data.remote.api

import com.asya.weatherapp.Configs
import com.asya.weatherapp.data.remote.model.CurrentWeatherResponse
import com.asya.weatherapp.shared.network.ErrorInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
   val moshi = Moshi.Builder()
      .add(KotlinJsonAdapterFactory())
      .build()

   val okHttp = OkHttpClient.Builder()
   .connectTimeout(Configs.Network.API_TIME_OUT, TimeUnit.SECONDS)
   .readTimeout(Configs.Network.API_TIME_OUT, TimeUnit.SECONDS)
   .retryOnConnectionFailure(true)
   .addInterceptor(ErrorInterceptor())
   .build()

   val weatherAPI = Retrofit.Builder()
      .baseUrl(Configs.Network.API_BASE_URL)
      .client(okHttp)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .build()
      .create(WeatherAPI::class.java)
}