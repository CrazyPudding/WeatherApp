package com.example.testdemo.weatherapp.domain.commands

import com.example.testdemo.weatherapp.domain.datasource.ForecastProvider
import com.example.testdemo.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
    val id: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<Forecast> {

    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}