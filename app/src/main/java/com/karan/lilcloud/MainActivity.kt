package com.karan.lilcloud

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import com.karan.lilcloud.composeUI.WeatherScreen
import com.karan.lilcloud.helper.PermissionManager
import com.karan.lilcloud.ui.theme.LilCloudTheme
import com.karan.lilcloud.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = WeatherViewModel()
    private val pM = PermissionManager(this)

    /**
      *object(Type : ActivityResultLauncher<String>) for requesting any kind of Permission
     **/
    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {isGranted ->
            if(isGranted) {
                TODO("Get GEO POSITION")
            }
            else {
                Toast.makeText(this@MainActivity, "Location Permission not Granted 💀❌", Toast.LENGTH_SHORT).show()
            }

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.Transparent.toArgb()
        window.navigationBarColor = Color.Transparent.toArgb()

        setContent {
            LilCloudTheme {
                viewModel.weatherData.value?.also {
                    val icon = it.weather?.get(0)?.icon.toString()
                    WeatherScreen(it, getBg = { viewModel.whichBg(icon) } )
                }
            }
        }

        if()

        pM.askLocationPermission(locationPermissionLauncher, android.Manifest.permission.ACCESS_FINE_LOCATION)

        val lat = 30.316496
        val lon = 78.032188
        val city = "London"
        viewModel.loadCurrentWeather(lat, lon, "metric")
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.light(Color.Transparent.toArgb(), Color.White.toArgb())
//        )


    }
}
