package com.karan.lilcloud.viewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.gson.Gson
import com.karan.lilcloud.R
import com.karan.lilcloud.helper.PermissionManager
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.DailyForecastResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Cache
import java.io.File
import java.util.Calendar
import kotlin.math.absoluteValue

open class WeatherViewModel( application: Application) : AndroidViewModel(application) {

    // Helper variables
    private val repo: WeatherRepository = WeatherRepository()
    private val applicationContext = application.applicationContext
    val pM: PermissionManager = PermissionManager(applicationContext)
    val locationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(applicationContext)

    // Control variables
    var showDialog = mutableStateOf<Boolean>(false)
    var showLoading = mutableStateOf<Boolean>(false)

    // API responses
    var geoLocation = mutableStateOf<GeoPositionResponse?>(null)
    var currentCondition = mutableStateOf<CurrentConditionResponse.CurrentConditionResponseItem?>(null)
    var dailyForecast = mutableStateOf<DailyForecastResponse?>(null)


    fun loadCurrentWeather(lat: Double, lon: Double) {
        val cacheFile1 = File(applicationContext.cacheDir, "current_condition.json")
        val cacheFile2 = File(applicationContext.cacheDir, "daily_forecast.json")
        if(cacheFile1.exists() && cacheFile2.exists()) {
            val json1 = cacheFile1.readText()
            currentCondition.value = Gson().fromJson(json1, CurrentConditionResponse.CurrentConditionResponseItem::class.java)
            val json2 = cacheFile2.readText()
            dailyForecast.value = Gson().fromJson(json2, DailyForecastResponse::class.java)
            Log.d("HowsTheWeather", "Caching Loaded Successfully !!! ")
            Log.d("HowsTheWeather", currentCondition.value.toString())
            Log.d("HowsTheWeather", dailyForecast.value.toString())
            return
        }

        val dispatcher = Dispatchers.IO

        viewModelScope.launch(dispatcher) {
            try {
                getLocationInfo("$lat,$lon")
                geoLocation.value?.key?.also {
                    getCurrentCondition(it)
                    getDailyForecast(it)
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

            // caching
            val json = Gson().toJson(currentCondition.value)
            val cacheFile = File(applicationContext.cacheDir, "current_condition.json")
            cacheFile.writeText(json)

            Log.d("HowsTheWeather", currentCondition.value.toString())
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error fetching CurrentCondition", e)
        }
    }

    suspend fun getDailyForecast(locationKey: String) {
        try {
            dailyForecast.value = repo.getDailyForecast(locationKey)

            //caching
            val json = Gson().toJson(dailyForecast.value)
            val cacheFile = File(applicationContext.cacheDir, "daily_forecast.json")
            cacheFile.writeText(json)

            Log.d("HowsTheWeather", dailyForecast.value.toString())
        } catch (e : Exception) {
            Log.e("HowsTheWeather", "Error fetching DailyForecast", e)
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

    fun whichWeatherIcon(n : Int) : Int{
        return when(n) {
            1,2,30 -> R.drawable.clear_day
            3,4,5,6 -> R.drawable.mostly_clear_day
            7,8,11,37 -> R.drawable.fog
            12,13,14,18,26,29,39,40 -> R.drawable.rain
            15,16,17,42,41 -> R.drawable.tstorm
            19,20,21,22,23,43,44 -> R.drawable.snow
            24,31 -> R.drawable.frost
            25 -> R.drawable.snow_and_sleet_mix
            32 -> R.drawable.wind
            33,34 -> R.drawable.clear_night
            35,36,38 -> R.drawable.mostly_clear_night
            else -> R.drawable.lil_cloud
        }
    }

    fun getTwilight() : Pair<Int, Pair<String, String>> {

        val regex = Regex("""(\d{2}):(\d{2})""")                      // Just need Hours and Minutes

        var sunrise : String = ""
        var sunset : String = ""

        val rise = dailyForecast.value?.dailyForecasts?.get(0)?.sun?.rise.toString().let {
            Log.d("HowsTheWeather", "Inside string")
            regex.find(it)?.groupValues?.let {
                sunrise = it[0]
                Log.d("HowsTheWeather", "Inside Regex : $sunrise")
                val hour = it[1].toInt()
                val min = it[2].toInt()
                hour * 60 + min
            }
        } ?: -1
        val set = dailyForecast.value?.dailyForecasts?.get(0)?.sun?.set.toString().let {
            regex.find(it)?.groupValues?.let {
                sunset = it[0]
                Log.d("HowsTheWeather", "Inside Regex : $sunset")
                val hour = it[1].toInt()
                val min = it[2].toInt()
                hour * 60 + min
            }
        } ?: -1

        val time = Calendar.getInstance().let {
            it.get(Calendar.HOUR_OF_DAY) * 60 + it.get(Calendar.MINUTE)
        }
        val progress : Int = ((time - rise)/(set - rise) * 34).absoluteValue

        Log.d("HowsTheWeather", "Inside Regex : $progress")

        return Pair(progress, Pair(sunrise, sunset))
    }
}
