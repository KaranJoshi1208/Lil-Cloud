package com.karan.lilcloud.repository

import com.karan.lilcloud.BuildConfig
import com.karan.lilcloud.model.RetrofitClient
import com.karan.lilcloud.model.accuWeather.ApiTemplate
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse

class WeatherRepository () {

    companion object {
        private const val API_KEY_ACCU = BuildConfig.API_KEY_ACCU
    }

    private val accuAPI = RetrofitClient.retrofit_ACCU.create(ApiTemplate::class.java)

    suspend fun getCurrentCondition(locationKey : String) : CurrentConditionResponse {
        return accuAPI.getCurrentCondition(locationKey, API_KEY_ACCU)
    }

    suspend fun getLocationInfo(geoPosition : String) : GeoPositionResponse {
        return accuAPI.getLocationInfo(geoPosition, API_KEY_ACCU)
    }

}