package com.karan.lilcloud

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.karan.lilcloud.navigation.NavGraph
import com.karan.lilcloud.ui.theme.LilCloudTheme
import com.karan.lilcloud.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel : WeatherViewModel
    private lateinit var navController: NavHostController

    /**
     *object(Type : ActivityResultLauncher<String>) for requesting any kind of Permission
     **/
    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this@MainActivity, "Location Permission Granted 👍💦", Toast.LENGTH_SHORT).show()
                viewModel.loadCurrentWeather()  // 2
            } else {
                viewModel.permissionDenied = true
                Toast.makeText(
                    this@MainActivity,
                    "Location Permission not Granted 💀❌",
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.loadCurrentWeather()    // 3
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
                needPermission()
                navController = rememberNavController()
                NavGraph(viewModel, navController, { needPermission() })
            }
        }
    }

    private fun needPermission() {
        if (!viewModel.pM.isPermissionGranted()) {
            viewModel.pM.askLocationPermission(
                locationPermissionLauncher,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        else {
            viewModel.loadCurrentWeather()   // 1
        }
    }
}
