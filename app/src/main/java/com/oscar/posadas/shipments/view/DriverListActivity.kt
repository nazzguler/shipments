package com.oscar.posadas.shipments.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oscar.posadas.shipments.R
import com.oscar.posadas.shipments.view.SuitabilityScoreActivity.Companion.DESTINATION_EXTRA
import com.oscar.posadas.shipments.viewmodel.DriverAndShipmentViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class DriverListActivity : AppCompatActivity(), DriverListView, DriverItemView {
    @Inject
    lateinit var driverAndShipmentViewModel: DriverAndShipmentViewModel
    private val tag = DriverListActivity::class.java.simpleName
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_list)
        progressBar = findViewById(R.id.progressBar)
        driverAndShipmentViewModel.driverListView = this
        driverAndShipmentViewModel.loadDriverList()
    }

    override fun onLoad() {
        progressBar?.visibility = VISIBLE
    }

    override fun onSuccess(driverList: List<String>) {
        progressBar?.visibility = GONE
        val recyclerView = findViewById<RecyclerView>(R.id.drivers)
        recyclerView.adapter = DriversAdapter(driverList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onError() {
        progressBar?.visibility = GONE
        Log.e(tag, getString(R.string.driver_list_error))
    }

    override fun onDriverClicked(driverName: String) {
        val destination = driverAndShipmentViewModel.getSuitableShipmentForDriver(driverName)
        val intent = Intent(this, SuitabilityScoreActivity::class.java).apply {
            putExtra(DESTINATION_EXTRA, destination)
        }
        startActivity(intent)
    }
}