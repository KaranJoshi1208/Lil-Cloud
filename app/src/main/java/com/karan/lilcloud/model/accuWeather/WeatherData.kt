package com.karan.lilcloud.model.accuWeather

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class WeatherData(
    var locationKey : String
) {
    var geoLocation = mutableStateOf<GeoPositionResponse?>(null)
    var currentCondition = mutableStateOf<CurrentConditionResponse.CurrentConditionResponseItem?>(null)
    var dailyForecast = mutableStateOf<DailyForecastResponse?>(null)
    var halfDayForecast = mutableStateListOf<HalfDayForecastResponse.HalfDayForecastResponseItem?>()
    var quinForecastResponse = mutableStateOf<QuinForecastResponse?>(null)
}