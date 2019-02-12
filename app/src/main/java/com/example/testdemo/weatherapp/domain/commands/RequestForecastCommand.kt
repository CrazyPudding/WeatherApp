package com.example.testdemo.weatherapp.domain.commands

import com.example.testdemo.weatherapp.domain.mappers.ForecastDataMapper
import com.example.testdemo.weatherapp.domain.model.ForecastList
import com.example.testdemo.weatherapp.data.server.Request as ForecastRequest

class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}
