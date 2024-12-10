package com.karan.lilcloud.repository

import com.karan.lilcloud.model.ApiService
import com.karan.lilcloud.model.Forecast
import com.karan.lilcloud.model.Weather
import retrofit2.Response
import com.karan.lilcloud.BuildConfig

class WeatherRepository (val api : ApiService){

    suspend fun getCurrentWeather(lat : Double, lon:Double, unit : String) : Weather {
        return api.getCurrentWeather(lat, lon, unit, BuildConfig.API_KEY_OWM)
    }

    suspend fun getForecastWeather(lat : Double, lon:Double, unit : String) : Forecast {
        return api.getForecastWeather(lat, lon, unit, BuildConfig.API_KEY_OWM)
    }

}