package com.oscar.posadas.shipments.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.oscar.posadas.shipments.model.DriverShipmentData
import com.oscar.posadas.shipments.utils.JsonReader.getJsonStringFromAsset
import javax.inject.Inject

class LocalRepository @Inject constructor(private val context: Context) {

    companion object {
        private const val driversAndShipments = "drivers_and_shipments.json"
    }

    fun getDriversAndShipments(): DriverShipmentData? {
        val jsonString: String? = getJsonStringFromAsset(context, driversAndShipments)
        val gson = Gson()
        val driverShipmentDataType = object : TypeToken<DriverShipmentData>() {}.type
        return gson.fromJson(jsonString, driverShipmentDataType)
    }
}