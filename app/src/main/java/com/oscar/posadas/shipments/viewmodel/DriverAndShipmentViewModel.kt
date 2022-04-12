package com.oscar.posadas.shipments.viewmodel

import androidx.lifecycle.ViewModel
import com.oscar.posadas.shipments.repository.LocalRepository
import com.oscar.posadas.shipments.utils.StringUtils.getConstantsCount
import com.oscar.posadas.shipments.utils.StringUtils.getLengthCommonFactors
import com.oscar.posadas.shipments.utils.StringUtils.getVowelsCount
import com.oscar.posadas.shipments.view.DriverListView
import javax.inject.Inject

class DriverAndShipmentViewModel @Inject constructor(private val repository: LocalRepository) :
    ViewModel() {

    var driverListView: DriverListView? = null
    private var suitableDriverAndShipment = mutableMapOf<String, String>()
    private var mShipments = mutableListOf<String>()

    /** This method will populate a map with the suitable shipment for each driver **/
    fun loadDriverList() {
        driverListView?.onLoad()
        val drivers = repository.getDriversAndShipments()?.drivers
        drivers?.let {
            for (driver in it) {
                suitableDriverAndShipment[driver] = getMaximizedSuitabilityScoreDestination(driver)
            }
            driverListView?.onSuccess(it)
        }?.run {
            driverListView?.onError()
        }
    }

    fun getSuitableShipmentForDriver(driver: String): String? {
        return suitableDriverAndShipment[driver]
    }

    private fun getShipments(): List<String>? {
        return repository.getDriversAndShipments()?.shipments
    }

    /** This method calculates the maximized suitability score destination for certain driver **/
    private fun getMaximizedSuitabilityScoreDestination(driverName: String): String {
        var destination = ""
        if (mShipments.isEmpty()) {
            getShipments()?.let {
                mShipments.addAll(it)
            }
        }
        mShipments.let { shipments ->
            var maximumBaseSuitabilityScore = 0.0

            for (ship in shipments) {

                var currentSuitabilityScore = if (ship.length % 2 == 0) {
                    ship.getVowelsCount() * 1.5
                } else {
                    (ship.getConstantsCount() * 1).toDouble()
                }
                val driverNameLengthCommonFactors = driverName.getLengthCommonFactors()
                val shipmentLengthCommonFactors = ship.getLengthCommonFactors()
                var shareCommonFactors = false

                for (factor in driverNameLengthCommonFactors) {
                    if (shipmentLengthCommonFactors.contains(factor)) {
                        shareCommonFactors = true
                        break
                    }
                }
                if (shareCommonFactors) {
                    currentSuitabilityScore *= 1.5
                }
                if (currentSuitabilityScore > maximumBaseSuitabilityScore) {
                    maximumBaseSuitabilityScore = currentSuitabilityScore
                    destination = ship
                }
            }
        }
        mShipments.remove(destination)
        return destination
    }

}