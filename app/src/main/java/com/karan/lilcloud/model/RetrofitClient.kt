package com.karan.lilcloud.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    val retrofit_OWM : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofit_ACCU : Retrofit = Retrofit.Builder()
        .baseUrl("http://dataservice.accuweather.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}