package com.google.android.gms.location.sample.locationupdatesbackgroundkotlin

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 * Helper functions to simplify permission checks/requests.
 */
fun Context.hasPermission(permission: String): Boolean {

    // Background permissions didn't exit prior to Q, so it's approved by default.
    if (permission == Manifest.permission.ACCESS_BACKGROUND_LOCATION &&
        android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.Q) {
        return true
    }

    return ActivityCompat.checkSelfPermission(this, permission) ==
            PackageManager.PERMISSION_GRANTED
}

/**
 * Requests permission and if the user denied a previous request, but didn't check
 * "Don't ask again", we provide additional rationale.
 *
 * Note: The Snackbar should have an action to request the permission.
 */
fun Fragment.requestPermissionWithRationale(
    permission: String,
    requestCode: Int,
    snackbar: Snackbar
) {
    val provideRationale = shouldShowRequestPermissionRationale(permission)

    if (provideRationale) {
        snackbar.show()
    } else {
        requestPermissions(arrayOf(permission), requestCode)
    }
}

/**
 * Requests permission and if the user denied a previous request, but didn't check
 * "Don't ask again", we provide additional rationale.
 *
 * Note: The Snackbar should have an action to request the permission.
 */

@RequiresApi(Build.VERSION_CODES.M)
fun Activity.requestPermissionWithRationale(
    permission: String,
    requestCode: Int,
    snackbar: Snackbar
) {
    val provideRationale = shouldShowRequestPermissionRationale(permission)

    if (provideRationale) {
        snackbar.show()
    } else {
        requestPermissions(arrayOf(permission), requestCode)
    }
}