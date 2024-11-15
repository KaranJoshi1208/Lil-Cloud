package com.karan.lilcloud.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat : Double,
        @Query("lon") lon : Double,
        @Query("units") units : String,
        @Query("appid") apiKey : String,
    ) : Weather
}