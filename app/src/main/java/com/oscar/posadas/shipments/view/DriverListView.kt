package com.oscar.posadas.shipments.view

interface DriverListView {
    fun onLoad()
    fun onSuccess(driverList: List<String>)
    fun onError()
}