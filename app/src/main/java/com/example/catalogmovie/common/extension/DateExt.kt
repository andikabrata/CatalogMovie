package com.example.catalogmovie.common.extension

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by dwiss.purwoko@gmail.com on 04/08/2021.
 */

@SuppressLint("SimpleDateFormat")
fun Date.toStringDate(pattern: String = "dd MMM yyyy"): String {
    val format = SimpleDateFormat(pattern, Locale("en", "us"))
    return format.format(this)
}