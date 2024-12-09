package com.karan.lilcloud.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karan.lilcloud.R
import com.karan.lilcloud.model.Forecast
import com.karan.lilcloud.model.Weather
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.repository.WeatherRepository
import kotlinx.coroutines.launch
import java.util.Calendar

class WeatherViewModel() : ViewModel() {

    private val repo: WeatherRepository = WeatherRepository()
    var weatherData = mutableStateOf<Weather?>(null)
    var forecastData = mutableStateOf<Forecast?>(null)

    var geoLocation = mutableStateOf<GeoPositionResponse?>(null)
    var currentCondition = mutableStateOf<CurrentConditionResponse.CurrentConditionResponseItem?>(null)

    fun loadCurrentWeather(lat: Double, lon: Double, unit: String) {
        viewModelScope.launch() {
            try {
                val response = repo.getCurrentWeather(lat, lon, unit)
                weatherData.value = response
                Log.d("HowsTheWeather", "Weather: $response")
            } catch (e: Exception) {
                Log.e("HowsTheWeather", "Error fetching weather", e)
            }
        }
    }

    fun loadForecastWeather(lat: Double, lon: Double, unit: String) {
        viewModelScope.launch() {
            try {
                val response = repo.getForecastWeather(lat, lon, unit)
                forecastData.value = response
                Log.d("HowsTheWeather", "Forecast: $response")
            } catch (e: Exception) {
                Log.e("HowsTheWeather", "Error fetching forecast", e)
            }
        }
    }

    fun getLocationInfo(geoPosition : String) {
        viewModelScope.launch() {
            try {
                val response = repo.getLocationInfo(geoPosition)
                geoLocation.value = response
            } catch (e : Exception) {
                Log.e("HowsTheWeather", "Error fetching GeoLocation", e)
            }
        }
    }

    fun getCurrentCondition(locationKey : String) {
        viewModelScope.launch() {
            try {
                val response = repo.getCurrentCondition(locationKey)
                currentCondition.value = response[0]
            } catch (e : Exception) {
                Log.e("HowsTheWeather", "Error fetching GeoLocation", e)
            }
        }
    }

    fun whichBg(icon: String): Int {
        return if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 18)
            R.drawable.night_bg else
            when (icon.dropLast(1)) {
                "01", "02" -> R.drawable.sunny_bg
                "03", "04", "50" -> R.drawable.haze_bg
                "09", "10", "11" -> R.drawable.rainy_bg
                "13" -> R.drawable.snow_bg
                else -> 0
            }
    }
}
