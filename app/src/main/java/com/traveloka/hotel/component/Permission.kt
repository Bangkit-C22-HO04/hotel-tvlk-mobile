package com.traveloka.hotel.component

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.LocationServices
import com.traveloka.hotel.core.domain.MainViewModel
import com.traveloka.hotel.core.domain.MainViewModelFactory
import java.util.*


fun checkPermission(context: Context, permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WithLocation(
    mainViewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory.getInstance(LocalContext.current)
    ),
    content: @Composable (getCurrentLocation: () -> Unit) -> Unit
) {
    val context = LocalContext.current

    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )

    val getCurrentLocation = {
        if (locationPermissionsState.allPermissionsGranted) {

            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

            if (
                checkPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) &&
                checkPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
            ) {
                fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        val geocoder = Geocoder(context, Locale.getDefault())
                        val addresses: List<Address> =
                            geocoder.getFromLocation(location.latitude, location.longitude, 1)
                        val cityName: String = addresses[0].subAdminArea
                        mainViewModel.setCity(cityName)
                    } else {
                        Log.d("Exception", "failed to get location")
                    }
                }
            }
        } else {
            locationPermissionsState.launchMultiplePermissionRequest()
            Toast.makeText(context, "This feature requires location permission", Toast.LENGTH_SHORT)
                .show()
        }
    }

    LaunchedEffect(true) {
        getCurrentLocation()
    }


    content(getCurrentLocation)
}