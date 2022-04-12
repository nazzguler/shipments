package com.oscar.posadas.shipments.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oscar.posadas.shipments.databinding.ActivitySuitabilityScoreBinding

class SuitabilityScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuitabilityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuitabilityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.destination.text = intent.getStringExtra(DESTINATION_EXTRA)
    }

    companion object {
        const val DESTINATION_EXTRA = "suitability_score_activity_destination_extra"
    }
}