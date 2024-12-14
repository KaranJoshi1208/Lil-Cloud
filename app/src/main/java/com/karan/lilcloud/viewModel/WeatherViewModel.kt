package com.karan.lilcloud.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karan.lilcloud.R
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.repository.WeatherRepository
import kotlinx.coroutines.launch
import java.util.Calendar

class WeatherViewModel() : ViewModel() {

    private val repo: WeatherRepository = WeatherRepository()

    var geoLocation = mutableStateOf<GeoPositionResponse?>(null)
    var currentCondition =
        mutableStateOf<CurrentConditionResponse.CurrentConditionResponseItem?>(null)

    fun loadCurrentWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            try {
                getLocationInfo("$lat,$lon")
            } catch (e: Exception) {
                Log.e("HowsTheWeather", "Error fetching geoLocation", e)
            }
            geoLocation.value?.let {
                try {
                    getCurrentCondition(geoLocation.value!!.key.toString())
                } catch (e: Exception) {
                    Log.e("HowsTheWeather", "Error fetching CurrentCondition", e)
                }
            } ?: Log.d("HowsTheWeather", "Location Response is NULL")
        }
    }

    suspend fun getLocationInfo(geoPosition: String) {
        try {
            val response = repo.getLocationInfo(geoPosition)
            geoLocation.value = response
            Log.d("HowsTheWeather", geoLocation.value.toString())
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error fetching GeoLocation", e)
        }
    }

    suspend fun getCurrentCondition(locationKey: String) {
        try {
            val response = repo.getCurrentCondition(locationKey)
            currentCondition.value = response[0]
            Log.d("HowsTheWeather", currentCondition.value.toString())
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error fetching CurrentCondition", e)
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
