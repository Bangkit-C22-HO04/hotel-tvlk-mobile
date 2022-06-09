package com.traveloka.hotel.core.util

import android.content.Context
import android.widget.Toast

fun showToast(ctx: Context, text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(ctx, text, duration).show()
}