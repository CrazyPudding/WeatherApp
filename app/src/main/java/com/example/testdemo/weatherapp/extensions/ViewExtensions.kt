package com.example.testdemo.weatherapp.extensions

import android.widget.TextView

var TextView.textColor: Int
    get() = currentTextColor
    set(value) = setTextColor(value)