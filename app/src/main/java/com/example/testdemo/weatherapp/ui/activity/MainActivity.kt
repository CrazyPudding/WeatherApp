package com.example.testdemo.weatherapp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.example.testdemo.weatherapp.R
import com.example.testdemo.weatherapp.domain.commands.RequestForecastCommand
import com.example.testdemo.weatherapp.extensions.DelegatesExt
import com.example.testdemo.weatherapp.ui.activity.DetailActivity.Companion.CITY_NAME
import com.example.testdemo.weatherapp.ui.activity.SettingsActivity.Companion.DEFAULT_ZIP
import com.example.testdemo.weatherapp.ui.activity.SettingsActivity.Companion.ZIP_CODE
import com.example.testdemo.weatherapp.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    private val zipCode: Long by DelegatesExt.preference(this, ZIP_CODE, DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = doAsync {
        val result = RequestForecastCommand(zipCode).execute()
        uiThread {
            val adapter = ForecastListAdapter(result) {
                startActivity<DetailActivity>(DetailActivity.ID to it.id,
                    CITY_NAME to result.city)
            }
            forecastList.adapter = adapter
            toolbarTitle = "${result.city} (${result.country})"
        }
    }
}
