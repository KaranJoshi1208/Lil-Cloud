package com.karan.lilcloud

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.karan.lilcloud.composeUI.WeatherScreen
import com.karan.lilcloud.helper.PermissionManager
import com.karan.lilcloud.ui.theme.LilCloudTheme
import com.karan.lilcloud.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = WeatherViewModel()
    private val pM : PermissionManager by lazy{
     PermissionManager(this@MainActivity.applicationContext)
    }
    private val locationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }

    /**
     *object(Type : ActivityResultLauncher<String>) for requesting any kind of Permission
     **/
    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this@MainActivity, "Location Granted 👍", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Location Permission not Granted 💀❌",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.Transparent.toArgb()
        window.navigationBarColor = Color.Transparent.toArgb()


        val lat = 30.316496
        val lon = 78.032188
        val city = "London"

        getGeoLocation()
//        viewModel.loadCurrentWeather(30.316496, 78.032188, "metric")

        setContent {
            LilCloudTheme {
                WeatherScreen(viewModel.weatherData.value)
            }
        }
    }

    private fun getGeoLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            pM.askLocationPermission(
                locationPermissionLauncher,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        locationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val lat = location.latitude
                    val lon = location.longitude
                    Log.d("HowsTheWeather", "Latitude: $lat, Longitude: $lon")
                    viewModel.loadCurrentWeather(lat, lon, "metric")
                }else{
                    Log.d("HowsTheWeather", "Latitude: NULL, Longitude: NULL")
                }
            }
            .addOnFailureListener {
                Log.e("HowsTheWeather", "Failed to get GEO POSITION", it)
            }
    }
}
