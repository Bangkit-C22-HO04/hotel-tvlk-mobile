package com.traveloka.hotel.common.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.traveloka.hotel.common.presentation.navigation.HotelNavigation
import com.traveloka.hotel.ui.theme.HotelmobileTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HotelmobileTheme {
                HotelNavigation()
            }
        }
    }

}
