package com.example.testdemo.weatherapp.domain.commands

public interface Command<out T>{
    fun execute(): T
}