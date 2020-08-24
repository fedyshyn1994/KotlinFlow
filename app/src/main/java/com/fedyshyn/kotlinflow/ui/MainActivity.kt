package com.fedyshyn.kotlinflow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.fedyshyn.kotlinflow.R
import com.fedyshyn.kotlinflow.utils.InjectorUtils
import com.fedyshyn.kotlinflow.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

private const val LOCATION_ID = 44418

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val homeViewModel: MainViewModel by viewModels {
        InjectorUtils.provideMainViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtInfo: TextView = findViewById(R.id.txtInfo)

        homeViewModel.loadLocationDetails(LOCATION_ID)
        homeViewModel.locationDetails.observe(this, {
            txtInfo.text = it.forecasts.toString()
        })
    }
}