package com.traveloka.hotel

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.traveloka.hotel.ui.navigation.HotelNavigation
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.ui.viewmodel.MainViewModel
import com.traveloka.hotel.ui.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var mainFactory: MainViewModelFactory
    private val mainViewModel by viewModels<MainViewModel> {
        mainFactory
    }
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mainFactory = MainViewModelFactory.getInstance(this)

        setContent {
            HotelmobileTheme {
                HotelNavigation()
            }
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        getMyLastLocation()
        return super.onCreateView(name, context, attrs)
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false -> {
                getMyLastLocation()
            }
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false -> {
                getMyLastLocation()
            }
            else -> {}
        }
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun getMyLastLocation() {
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION) && checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    mainViewModel.setLocation(LatLng(location.latitude, location.longitude))
                } else {
                    Log.d("Exception", "failed to get location")
                }
            }
        } else {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

}
