package com.karan.lilcloud.helper

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.DailyForecastResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.model.accuWeather.HalfDayForecastResponse
import com.karan.lilcloud.model.accuWeather.QuinForecastResponse

class WeatherDataConverters {
    private val gson = Gson()

    @TypeConverter
    fun storeGeoPosition(value: GeoPositionResponse?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun getGeoPosition(value: String): GeoPositionResponse? {
        return gson.fromJson(value, object : TypeToken<GeoPositionResponse>() {}.type)
    }

    @TypeConverter
    fun storeCurrentCondition(value: CurrentConditionResponse.CurrentConditionResponseItem?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun getCurrentCondition(value: String): CurrentConditionResponse.CurrentConditionResponseItem? {
        return gson.fromJson(value, object : TypeToken<CurrentConditionResponse.CurrentConditionResponseItem>() {}.type)
    }

    @TypeConverter
    fun fromDailyForecast(value: DailyForecastResponse?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun getDailyForecast(value: String): DailyForecastResponse? {
        return gson.fromJson(value, object : TypeToken<DailyForecastResponse>() {}.type)
    }

    @TypeConverter
    fun storeHalfDayForecast(value: List<HalfDayForecastResponse.HalfDayForecastResponseItem?>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun getHalfDayForecast(value: String): List<HalfDayForecastResponse.HalfDayForecastResponseItem?> {
        return gson.fromJson(value, object : TypeToken<List<HalfDayForecastResponse.HalfDayForecastResponseItem?>>() {}.type)
    }

    @TypeConverter
    fun storeQuinForecast(value: QuinForecastResponse?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun getQuinForecast(value: String): QuinForecastResponse? {
        return gson.fromJson(value, object : TypeToken<QuinForecastResponse>() {}.type)
    }
}
