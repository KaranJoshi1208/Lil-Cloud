package com.karan.lilcloud.viewModel

import android.annotation.SuppressLint
import java.time.format.TextStyle
import android.app.Application
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.karan.lilcloud.R
import com.karan.lilcloud.helper.PermissionManager
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import com.karan.lilcloud.model.accuWeather.DailyForecastResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.model.accuWeather.HalfDayForecastResponse
import com.karan.lilcloud.model.accuWeather.QuinForecastResponse
import com.karan.lilcloud.model.accuWeather.SearchResponse
import com.karan.lilcloud.model.room.WeatherData
import com.karan.lilcloud.model.room.WeatherDataBase
import com.karan.lilcloud.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    // Keys
    companion object {
        private const val PREF_FILE = "lil_prefs"
        private const val LOCATIONS_LIST_KEY = "location_list"
    }

    val dispatcher = Dispatchers.IO

    // Helper variables
    private val db = WeatherDataBase.getWeatherDataBase(application)
    private val repo: WeatherRepository = WeatherRepository(db)
    private val applicationContext = application.applicationContext
    val pM: PermissionManager = PermissionManager(applicationContext)
    val locationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(applicationContext)
    val gson = Gson()

    var permissionDenied: Boolean = false

    var requestPermission = MutableStateFlow(false)

    var data = MutableStateFlow<List<WeatherData>>(emptyList())
    var searchResponse = mutableStateListOf<SearchResponse.SearchResponseItem?>()


    init {
        viewModelScope.launch(dispatcher) {
            repo.getAllWeatherData().collect {
                data.value = it
                Log.d("HowsTheWeather", "database of size : ${data.value.size}")
            }
        }

        // reducing API calls , since I am using a free API
        searchResponse.addAll(
            gson.fromJson(
                application.resources.openRawResource(R.raw.search).bufferedReader()
                    .use { it.readText() },
                Array<SearchResponse.SearchResponseItem?>::class.java
            )
        )

    }

    // Control variables
    var showDialog = mutableStateOf<Boolean>(false)
    var showLoading = mutableStateOf<Boolean>(false)
    var isSearching = false
    var navIt = mutableStateOf<Boolean>(false)


    // API responses
    var geoLocation = mutableStateOf<GeoPositionResponse?>(null)
    var currentCondition =
        mutableStateOf<CurrentConditionResponse.CurrentConditionResponseItem?>(null)
    var dailyForecast = mutableStateOf<DailyForecastResponse?>(null)
    var halfDayForecast = mutableStateListOf<HalfDayForecastResponse.HalfDayForecastResponseItem?>()
    var quinForecastResponse = mutableStateOf<QuinForecastResponse?>(null)







    fun loadCurrentWeather() {

        if (data.value.isEmpty()) {

            if (!isLocationEnabled()) {
                showDialog.value = true
            }

            if (!permissionDenied && isLocationEnabled()) {

                val weather = WeatherData(isCurrentLocation = true)
                getCoordinates { coordinates ->
                    if (coordinates != null) {
                        addCurrentLocation("${coordinates.first},${coordinates.second}", weather)
                    } else {
                        Log.e("HowsTheWeather", "Failed to retrieve coordinates.")
                    }
                }
            } else {
                navIt.value = true
            }
            return
        }

//        TODO("Check if the 'data' is outdated ?")
    }


    fun addCurrentLocation(geoPosition: String, weather: WeatherData) {
        showLoading.value = true
        viewModelScope.launch(dispatcher) {
            try {
                val gl = getLocationInfo(geoPosition)
                gl?.key?.also { key ->
                    val cc = async { getCurrentCondition(key) }
                    val df = async { getDailyForecast(key) }
                    val hdf = async { getHalfDayForecast(key) }
                    val qf = async { getQuinForecast(key) }

                    weather.apply {
                        locationKey = key
                        geoLocation = gl
                        currentCondition = cc.await()
                        dailyForecast = df.await()
                        halfDayForecast = hdf.await()
                        quinForecastResponse = qf.await()
                    }

                    repo.insertWeatherData(weather)

                } ?: Log.d("HowsTheWeather", "Location Response is NULL")

            } catch (e: Exception) {
                Log.e("HowsTheWeather", "Error fetching geoLocation", e)
            } finally {
                showLoading.value = false
                Log.d("HowsTheWeather", "Loading Screen : ${showLoading.value}")
            }
        }
    }

    fun load(weather: WeatherData) {
        showLoading.value = true
        viewModelScope.launch(dispatcher) {
            try {
                weather.locationKey.also { key ->
                    val gl = async { getLocationKeyInfo(key) }
                    val cc = async { getCurrentCondition(key) }
                    val df = async { getDailyForecast(key) }
                    val hdf = async { getHalfDayForecast(key) }
                    val qf = async { getQuinForecast(key) }

                    weather.apply {
                        locationKey = key
                        geoLocation = gl.await()
                        currentCondition = cc.await()
                        dailyForecast = df.await()
                        halfDayForecast = hdf.await()
                        quinForecastResponse = qf.await()
                    }

                    repo.insertWeatherData(weather)

                }

            } catch (e: Exception) {
                Log.e("HowsTheWeather", "Error loading weather", e)
            } finally {
                showLoading.value = false
                Log.d("HowsTheWeather", "Loading Screen : ${showLoading.value}")
            }
        }
    }

    fun refresh(weather: WeatherData) {

        if(showLoading.value) return

        if (weather.isCurrentLocation && isLocationEnabled()) {

            getCoordinates { coordinates ->
                if (coordinates != null) {
//                        weather.locationKey = "${coordinates.first},${coordinates.second}"
                    addCurrentLocation("${coordinates.first},${coordinates.second}", weather)
                } else {
                    Log.e("HowsTheWeather", "Failed to retrieve coordinates.(During Refresh)")
                }

            }
        } else {
            load(weather)
        }
    }


    fun addLocation(key: String?): Boolean {
        // this function believes that this is not a duplicate call for same location
        key?.let {
            load(WeatherData(locationKey = key))
        } ?: return false
        return true
    }

    fun searchLocation(query: String) {
        isSearching = true
        viewModelScope.launch(dispatcher) {
            try {
                searchResponse.apply {
                    clear()
                    addAll(repo.getSearchResponse(query))
                }
            } catch (e: Exception) {
                Log.e("HowsTheWeather", "Error Fetching Search Results", e)
            }finally {
                isSearching = false
            }
        }
    }


    // API Calls

    suspend fun getLocationInfo(geoPosition: String): GeoPositionResponse? {
        var response: GeoPositionResponse? = null

        try {
            response = repo.getLocationInfo(geoPosition)
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error Fetching Location Info (using Geo position)", e)
        }

        return response
    }

    suspend fun getLocationKeyInfo(locationKey: String): GeoPositionResponse? {
        var response: GeoPositionResponse? = null

        try {
            response = repo.getLocationKeyInfo(locationKey)
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error Fetching Location Info (using Location Key)", e)
        }

        return response
    }

    suspend fun getCurrentCondition(locationKey: String): CurrentConditionResponse.CurrentConditionResponseItem? {
        var response: CurrentConditionResponse? = null

        try {
            response = repo.getCurrentCondition(locationKey)
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error fetching CurrentCondition", e)
        }

        return response?.get(0)
    }

    suspend fun getDailyForecast(locationKey: String): DailyForecastResponse? {
        var response: DailyForecastResponse? = null

        try {
            response = repo.getDailyForecast(locationKey)
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error fetching DailyForecast", e)
        }
        return response
    }


    suspend fun getHalfDayForecast(locationKey: String): HalfDayForecastResponse? {
        var response: HalfDayForecastResponse? = null

        try {
            response = repo.getHalfDayForecast(locationKey)
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error fetching Half Day Forecast", e)
        }

        return response
    }

    suspend fun getQuinForecast(locationKey: String): QuinForecastResponse? {
        var response: QuinForecastResponse? = null

        try {
            response = repo.getQuinForecast(locationKey)
        } catch (e: Exception) {
            Log.e("HowsTheWeather", "Error Fetching 5-days Forecast", e)
        }

        return response
    }


    // Utility functions

    fun setPrefLocations(locations: MutableList<String>) {
        val json = gson.toJson(locations)
        val pref = applicationContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
        pref.edit().putString(LOCATIONS_LIST_KEY, json).apply()
    }

    fun getPrefLocations(): MutableList<String> {
        val pref = applicationContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
        val json = pref.getString(LOCATIONS_LIST_KEY, null) ?: return mutableListOf<String>()
        return gson.fromJson(json, object : TypeToken<MutableList<String>>() {}.type)
    }

    fun regex(str: String, reg: Regex): String {
        return reg.find(str)?.groupValues?.get(1).toString()
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

    fun whichWeatherIcon(n: Int): Int {
        return when (n) {
            1, 2, 30 -> R.drawable.clear_day
            3, 4, 5, 6 -> R.drawable.mostly_clear_day
            7, 8, 11, 37 -> R.drawable.fog
            12, 13, 14, 18, 26, 29, 39, 40 -> R.drawable.rain
            15, 16, 17, 42, 41 -> R.drawable.tstorm
            19, 20, 21, 22, 23, 43, 44 -> R.drawable.snow
            24, 31 -> R.drawable.frost
            25 -> R.drawable.snow_and_sleet_mix
            32 -> R.drawable.wind
            33, 34 -> R.drawable.clear_night
            35, 36, 38 -> R.drawable.mostly_clear_night
            else -> R.drawable.lil_cloud
        }
    }

    // Data Providers

    fun getTwilight(df: DailyForecastResponse): Pair<Int, Pair<String, String>> {

        // Just need Hours and Minutes
        val regex = Regex("""(\d{2}):(\d{2})""")

        var sunrise: String = ""
        var sunset: String = ""

        val rise = df.dailyForecasts?.get(0)?.sun?.rise.toString().let {
            Log.d("HowsTheWeather", "Inside string")
            regex.find(it)?.groupValues?.let {
                sunrise = it[0]
                Log.d("HowsTheWeather", "Inside Regex : $sunrise")
                val hour = it[1].toInt()
                val min = it[2].toInt()
                hour * 60 + min
            }
        } ?: -1
        val set = df.dailyForecasts?.get(0)?.sun?.set.toString().let {
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
        val progress: Int = ((time - rise).toFloat() / (set - rise) * 32).toInt()

        Log.d("HowsTheWeather", "Inside Regex Progress : $progress")

        return Pair(progress, Pair(sunrise, sunset))
    }


    fun getDayName(n: Long): String {
        val day = LocalDate.now().plusDays(n)
        return when (n) {
            0L -> "Today"
            1L -> "Tomorrow"
            else -> day.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
        }
    }


    // Use only when Permission is provided
    @SuppressLint("MissingPermission")
    fun getCoordinates(useCoordinates: (Pair<Double, Double>?) -> Unit) {
        var cord: Pair<Double, Double>? = null
        locationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { location ->
                if (location != null) {
                    cord = Pair(location.latitude, location.longitude)
                    Log.d(
                        "HowsTheWeather",
                        "Latitude: ${cord.first}, Longitude: ${cord.second}"
                    )
                    useCoordinates(cord)
                } else {
                    Log.d("HowsTheWeather", "Latitude: NULL, Longitude: NULL")
                }
            }
            .addOnFailureListener {
                Log.e("HowsTheWeather", "Failed to get GEO POSITION", it)
            }
    }

}
