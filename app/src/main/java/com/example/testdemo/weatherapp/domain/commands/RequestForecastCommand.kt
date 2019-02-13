package com.example.testdemo.weatherapp.domain.commands

import com.example.testdemo.weatherapp.domain.datasource.ForecastProvider
import com.example.testdemo.weatherapp.domain.model.ForecastList
import com.example.testdemo.weatherapp.data.server.ForecastByZipCodeRequest as ForecastRequest

class RequestForecastCommand(
    private val zipCode: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
}
