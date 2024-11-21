package com.karan.lilcloud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import com.karan.lilcloud.composeUI.WeatherScreen
import com.karan.lilcloud.ui.theme.LilCloudTheme
import com.karan.lilcloud.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = WeatherViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.Transparent.toArgb()
        window.navigationBarColor = Color.Transparent.toArgb()

        val lat = 30.316496
        val lon = 78.032188
        val city = "London"
        viewModel.loadCurrentWeather(lat, lon, "metric")
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.light(Color.Transparent.toArgb(), Color.White.toArgb())
//        )
        setContent {
            LilCloudTheme {
                viewModel.weatherData.value?.also {
                    val icon = it.weather?.get(0)?.icon.toString()
                    WeatherScreen(it, getBg = { viewModel.whichBg(icon) } )
                }
            }
        }

    }
}
