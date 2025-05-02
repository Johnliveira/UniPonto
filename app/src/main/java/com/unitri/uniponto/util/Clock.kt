package com.unitri.uniponto.util

import java.time.LocalDateTime

class Clock {

    private fun getTime(): LocalDateTime {
        return LocalDateTime.now()
    }

    fun getHour(): Int {
        return getTime().hour
    }

    fun getMinute(): Int {
        return getTime().minute
    }
}