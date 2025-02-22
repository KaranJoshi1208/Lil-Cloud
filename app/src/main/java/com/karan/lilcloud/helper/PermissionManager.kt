package com.karan.lilcloud.helper

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat

class PermissionManager(
    val application: Context, val request: ActivityResultLauncher<String>
) {
    companion object {}

    fun askLocationPermission(request: ActivityResultLauncher<String>, permission: String) =
        request.launch(permission)

    fun isPermissionGranted(): Boolean {
        return (ContextCompat.checkSelfPermission(
            application, Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
            application, Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED)
    }
}