package com.example.testdemo.weatherapp.domain.commands

import com.example.testdemo.weatherapp.domain.mappers.ForecastDataMapper
import com.example.testdemo.weatherapp.domain.model.ForecastList
import com.example.testdemo.weatherapp.data.Request as ForecastRequest

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}
