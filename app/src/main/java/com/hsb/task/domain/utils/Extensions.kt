package com.hsb.task.domain.utils

import android.icu.util.Calendar
import android.os.Build
import java.time.LocalDateTime

object Extensions {

    fun Any.name(): String = this.javaClass.simpleName.trim()
    fun getCurrentHour(): Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDateTime.now().hour
    } else {
        // Use Calendar for versions below O
        Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    }

    fun greetingMessage(userName: String): String {
        val greetingMessage = when (getCurrentHour()) {
            in 5..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            in 18..21 -> "Good Evening"
            else -> "Good Night"
        }
        return "$greetingMessage $userName !"
    }

    //Other Extension are used from my Extension Library (Extensions_hsb)
    //https://github.com/syedhaseeb1/extensions_hsb find here
}