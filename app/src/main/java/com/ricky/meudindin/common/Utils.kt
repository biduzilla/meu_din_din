package com.ricky.meudindin.common

import java.util.Calendar

fun calculateDateAgo(amount: Int, field: Int): Long {
    val calendar = Calendar.getInstance()
    calendar.add(field, -amount)
    return calendar.timeInMillis
}