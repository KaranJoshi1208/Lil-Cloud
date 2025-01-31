package com.karan.lilcloud.repository

import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import com.karan.lilcloud.BuildConfig
import com.karan.lilcloud.model.RetrofitClient
import com.karan.lilcloud.model.accuWeather.ApiTemplate
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.DailyForecastResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.model.accuWeather.HalfDayForecastResponse
import com.karan.lilcloud.model.accuWeather.QuinForecastResponse
import com.karan.lilcloud.model.room.WeatherData
import com.karan.lilcloud.model.room.WeatherDataBase

class WeatherRepository (db : WeatherDataBase) {

    companion object {
        private const val API_KEY_ACCU = BuildConfig.API_KEY_ACCU
    }

    private val accuAPI = RetrofitClient.retrofit_ACCU.create(ApiTemplate::class.java)
    private val dao = db.weatherDao()

    suspend fun getCurrentCondition(locationKey : String) : CurrentConditionResponse {
        return accuAPI.getCurrentCondition(locationKey, API_KEY_ACCU)
    }

    suspend fun getLocationInfo(geoPosition : String) : GeoPositionResponse {
        return accuAPI.getLocationInfo(geoPosition, API_KEY_ACCU)
    }

    suspend fun getDailyForecast(locationKey : String) : DailyForecastResponse {
        return accuAPI.getDailyForecast(locationKey, API_KEY_ACCU)
    }

    suspend fun getHalfDayForecast(locationKey : String) : HalfDayForecastResponse {
        return accuAPI.getHalfDayForecast(locationKey, API_KEY_ACCU)
    }

    suspend fun getQuinForecast(locationKey: String) : QuinForecastResponse {
        return accuAPI.getQuinForecast(locationKey, API_KEY_ACCU)
    }


    // db

    suspend fun getAllWeatherData() : List<WeatherData>{
        return dao.getAllWeatherData()
    }
}