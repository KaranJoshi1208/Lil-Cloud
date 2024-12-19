package com.karan.lilcloud.viewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.karan.lilcloud.R
import com.karan.lilcloud.helper.PermissionManager
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

open class WeatherViewModel( application: Application) : AndroidViewModel(application) {

    private val repo: WeatherRepository = WeatherRepository()
    private val applicationContext = application.applicationContext

    val pM: PermissionManager = PermissionManager(applicationContext)
    val locationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(applicationContext)

    var showDialog = mutableStateOf<Boolean>(false)
    var showLoading = mutableStateOf<Boolean>(false)
    var geoLocation = mutableStateOf<GeoPositionResponse?>(null)
    var currentCondition = mutableStateOf<CurrentConditionResponse.CurrentConditionResponseItem?>(null)

    fun loadCurrentWeather(lat: Double, lon: Double) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                getLocationInfo("$lat,$lon")
                geoLocation.value?.let {
                    getCurrentCondition(geoLocation.value!!.key.toString())
                } ?: Log.d("HowsTheWeather", "Location Response is NULL")

            } catch (e: Exception) {
                Log.e("HowsTheWeather", "Error fetching geoLocation", e)
            } finally {
                showLoading.value = false
                Log.d("HowsTheWeather", "Loading Screen : ${showLoading.value}")
            }
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


    fun isLocationEnabled(): Boolean {
        val locationManager =
            applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    fun showLocationSettings() {
        showDialog.value = false
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        applicationContext.startActivity(intent)
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
