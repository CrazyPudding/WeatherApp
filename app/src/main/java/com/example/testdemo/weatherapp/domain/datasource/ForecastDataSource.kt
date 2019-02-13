package com.example.testdemo.weatherapp.domain.datasource

import com.example.testdemo.weatherapp.domain.model.Forecast
import com.example.testdemo.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}