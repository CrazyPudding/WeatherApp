package com.example.testdemo.weatherapp.domain.datasource

import com.example.testdemo.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}