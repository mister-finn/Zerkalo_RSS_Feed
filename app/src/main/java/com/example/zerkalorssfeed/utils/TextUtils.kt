package com.example.zerkalorssfeed.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

private const val STRING_DATE = "EEE, dd MMM yyyy HH:mm:ss Z"

fun String.stringDateToStamp(): Long {
    val dateFormat: Date = SimpleDateFormat(STRING_DATE, Locale.UK).parse(this)
    return dateFormat.time
}


fun Long.timeStampToDate(): String {
    val stamp = Timestamp(this)
    val date = Date(stamp.time)
    val pattern = "EEEE, dd MMMM yyyy, HH:mm"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    var result = sdf.format(date)
    result = result.substring(0, 1).uppercase(Locale.ROOT) + result.substring(1)
    return result
}


fun String.getDescription(): String {
    val pattern = Pattern.compile(">(.*?)<")
    val matcher = pattern.matcher(this)
    var result = ""
    while (matcher.find()) {
        result = matcher.group(1)
    }
    return result
}

fun String.getSmallPhotoUrl(): String {
    val pattern = Pattern.compile("img src=\"(.*?)\"")
    val matcher = pattern.matcher(this)
    var result = ""
    while (matcher.find()) {
        result = matcher.group(1)
    }
    return if (result.isEmpty()) {
        "https://dh.img.tyt.by/n/it/kartinki_logo/0b/8/davlenie_title_logo_1x_rus.png"
    } else {
        result
    }
}