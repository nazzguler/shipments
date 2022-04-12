package com.oscar.posadas.shipments.utils

import android.content.Context
import java.io.IOException

object JsonReader {
    fun getJsonStringFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}