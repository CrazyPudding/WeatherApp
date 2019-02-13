package com.example.testdemo.weatherapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testdemo.weatherapp.R
import com.example.testdemo.weatherapp.domain.model.Forecast
import com.example.testdemo.weatherapp.domain.model.ForecastList
import com.example.testdemo.weatherapp.extensions.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast.*
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: (Forecast) -> Unit) :
    RecyclerView.Adapter<ForecastListAdapter.ForecastHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)

        return ForecastHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ForecastHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ForecastHolder(override val containerView: View, private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(icon)
                dateText.text = date.toDateString()
                descriptionText.text = description
                maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener{itemClick(this)}
            }
        }
    }
}