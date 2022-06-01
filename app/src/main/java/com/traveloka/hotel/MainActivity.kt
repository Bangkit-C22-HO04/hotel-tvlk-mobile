package com.traveloka.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.traveloka.hotel.ui.navigation.HotelNavigation
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.HotelmobileTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(Blue)
            }
            HotelmobileTheme {
                HotelNavigation()
            }
        }
    }

}
