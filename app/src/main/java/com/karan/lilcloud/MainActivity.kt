package com.karan.lilcloud

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.karan.lilcloud.composeUI.EnableLocationDialog
import com.karan.lilcloud.composeUI.Loading
import com.karan.lilcloud.composeUI.WeatherScreen
import com.karan.lilcloud.helper.PermissionManager
import com.karan.lilcloud.ui.theme.LilCloudTheme
import com.karan.lilcloud.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel : WeatherViewModel

    /**
     *object(Type : ActivityResultLauncher<String>) for requesting any kind of Permission
     **/
    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this@MainActivity, "Location Permission Granted 👍💦", Toast.LENGTH_SHORT).show()
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

        viewModel = ViewModelProvider(
            this@MainActivity,
            ViewModelProvider.AndroidViewModelFactory()
        )[WeatherViewModel::class.java]

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.Transparent.toArgb()
        window.navigationBarColor = Color.Transparent.toArgb()


        setContent {
            LilCloudTheme {
                WeatherScreen(viewModel)
                if(viewModel.currentCondition.value == null && !viewModel.showLoading.value) {
                    getGeoLocation()
                }
            }
        }
    }

    private fun getGeoLocation() {
        if (!viewModel.isLocationEnabled()) {
            viewModel.showDialog.value = true
        }
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            viewModel.pM.askLocationPermission(
                locationPermissionLauncher,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        viewModel.showLoading.value = true                             /// here I am , fuckin around !!
        Log.d("HowsTheWeather", "Loading Screen : ${viewModel.showLoading.value}")

        viewModel.locationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { location ->
                if (location != null) {
                    val lat = location.latitude
                    val lon = location.longitude
                    Log.d("HowsTheWeather", "Latitude: $lat, Longitude: $lon")
                    viewModel.loadCurrentWeather(lat, lon)
                } else {
                    Log.d("HowsTheWeather", "Latitude: NULL, Longitude: NULL")
                }
            }
            .addOnFailureListener {
                Log.e("HowsTheWeather", "Failed to get GEO POSITION", it)
            }
    }

    override fun onResume() {
        super.onResume()
        if(viewModel.currentCondition.value == null && !viewModel.showLoading.value) {
            getGeoLocation()
        }
    }
}
