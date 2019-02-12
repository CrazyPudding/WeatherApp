package com.example.testdemo.weatherapp.domain.model

data class ForecastList(
    val _id: Long, val city: String, val country: String,
    val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int): Forecast = dailyForecast[position]
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)