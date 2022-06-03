package com.traveloka.hotel.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.dateFormat(): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US)
    val date = format.parse(this) as Date
    return DateFormat.getDateInstance(DateFormat.DEFAULT).format(date)
}