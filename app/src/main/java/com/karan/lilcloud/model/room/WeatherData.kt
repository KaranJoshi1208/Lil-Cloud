package com.karan.lilcloud.model.room

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
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
    @PrimaryKey val id : Int,
    @PrimaryKey val locationKey : String,
    val geoLocation : MutableState<GeoPositionResponse?>,
    val currentCondition : MutableState<CurrentConditionResponse.CurrentConditionResponseItem?>,
    val dailyForecast : MutableState<DailyForecastResponse?>,
    val halfDayForecast : SnapshotStateList<HalfDayForecastResponse.HalfDayForecastResponseItem?>,
    val quinForecastResponse : MutableState<QuinForecastResponse?>
)