package com.karan.lilcloud

import android.app.StatusBarManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.karan.lilcloud.composeUI.WeatherScreen
import com.karan.lilcloud.ui.theme.LilCloudTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.Transparent.toArgb()
        window.navigationBarColor = Color.Transparent.toArgb()
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.light(Color.Transparent.toArgb(), Color.White.toArgb())
//        )
        setContent {
            LilCloudTheme {
                WeatherScreen()
            }
        }
    }
}
