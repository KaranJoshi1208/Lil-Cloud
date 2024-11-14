package com.karan.lilcloud.repository


import com.karan.lilcloud.model.ApiService
import com.karan.lilcloud.model.Weather
import retrofit2.Call

class WeatherRepository (val api : ApiService){

    companion object {
        private const val API_KEY = "ef06752d9a98a30a606728b7b3c06853"
    }

    suspend fun getCurrentWeather(lat : Double, lon:Double, unit : String) : Call<Weather> {
        return api.getCurrentWeather(lat, lon, unit, API_KEY)
    }

}