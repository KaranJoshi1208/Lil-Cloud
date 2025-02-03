package com.karan.lilcloud.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.karan.lilcloud.helper.WeatherDataConverters
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.DailyForecastResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.model.accuWeather.HalfDayForecastResponse
import com.karan.lilcloud.model.accuWeather.QuinForecastResponse

@Entity(tableName = "weather_data")
@TypeConverters(WeatherDataConverters::class)
class WeatherData(
    @PrimaryKey var locationKey : String = "",
    var geoLocation : GeoPositionResponse? = null,
    var currentCondition : CurrentConditionResponse.CurrentConditionResponseItem? = null,
    var dailyForecast : DailyForecastResponse? = null,
    var halfDayForecast : HalfDayForecastResponse? = null,
    var quinForecastResponse : QuinForecastResponse? = null,
    var isCurrentLocation : Boolean = false
)