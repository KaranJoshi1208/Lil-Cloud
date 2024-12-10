package com.karan.lilcloud.repository

import com.karan.lilcloud.model.ApiService
import com.karan.lilcloud.model.Forecast
import com.karan.lilcloud.model.Weather
import com.karan.lilcloud.BuildConfig
import com.karan.lilcloud.model.RetrofitClient
import com.karan.lilcloud.model.accuWeather.ApiTemplate
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse

class WeatherRepository () {

    companion object {
        private const val API_KEY_OWM = BuildConfig.API_KEY_OWM
        private const val API_KEY_ACCU = BuildConfig.API_KEY_ACCU
    }

    private val owmAPI by lazy {
        RetrofitClient.retrofit_OWM.create(ApiService::class.java)
    }
    private val accuAPI by lazy {
        RetrofitClient.retrofit_ACCU.create(ApiTemplate::class.java)
    }

    suspend fun getCurrentWeather(lat : Double, lon:Double, unit : String) : Weather {
        return owmAPI.getCurrentWeather(lat, lon, unit, API_KEY_OWM)
    }

    suspend fun getForecastWeather(lat : Double, lon:Double, unit : String) : Forecast {
        return owmAPI.getForecastWeather(lat, lon, unit, API_KEY_OWM)
    }

    suspend fun getCurrentCondition(locationKey : String) : CurrentConditionResponse {
        return accuAPI.getCurrentCondition(locationKey, API_KEY_ACCU)
    }

    suspend fun getLocationInfo(geoPosition : String) : GeoPositionResponse {
        return accuAPI.getLocationInfo(geoPosition, API_KEY_ACCU)
    }

}