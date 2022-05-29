package com.traveloka.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.traveloka.hotel.navigation.HotelNavigation
import com.traveloka.hotel.ui.theme.HotelmobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelmobileTheme {
                // A surface container using the 'background' color from the theme
                HotelNavigation()
            }
        }
    }
}
