package com.oscar.posadas.shipments.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oscar.posadas.shipments.R

class DriversAdapter(
    private val drivers: List<String>,
    private val onDriverClickListener: DriverItemView
) :
    RecyclerView.Adapter<DriversAdapter.DriversViewHolder>() {

    class DriversViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val driverName: TextView? = item.findViewById(R.id.driverName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriversViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val driverItem = layoutInflater.inflate(R.layout.driver_item, parent, false)
        return DriversViewHolder(driverItem)
    }

    override fun onBindViewHolder(holder: DriversViewHolder, position: Int) {
        val currentDriver = drivers[position]
        holder.driverName?.text = currentDriver
        holder.driverName?.setOnClickListener {
            onDriverClickListener.onDriverClicked(currentDriver)
        }
    }

    override fun getItemCount(): Int {
        return drivers.size
    }
}