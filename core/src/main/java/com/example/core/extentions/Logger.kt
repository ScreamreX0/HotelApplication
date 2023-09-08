package com.example.core.extentions

import android.util.Log

fun Any.log(prefix: String = "") = Log.i(LOGGER_DEFAULT_TAG, prefix + toString())
fun Any.log(tag: String, prefix: String = "") = Log.i(tag, "$prefix ${toString()}")

const val LOGGER_DEFAULT_TAG = "LOGGER_DEFAULT_TAG"