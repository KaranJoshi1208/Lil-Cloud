package com.karan.lilcloud.helper

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat

class PermissionManager(
    val context : Context
) {

    fun askLocationPermission(request : ActivityResultLauncher<String>, permission : String) = request.launch(permission)

    fun isPermissionGranted(permission : String) = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}