package com.unitri.uniponto.util

import java.time.LocalDateTime

class Clock {

    private fun getTime(): LocalDateTime = LocalDateTime.now()

    fun getHour(): String = String.format("%02d", getTime().hour)

    fun getMinute(): String = String.format("%02d", getTime().minute)
}