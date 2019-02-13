package com.example.testdemo.weatherapp.extensions

import android.view.View
import android.widget.TextView

var TextView.textColor: Int
    get() = currentTextColor
    set(value) = setTextColor(value)

fun View.slidExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slidEnter() {
    if (translationY < 0f) animate().translationY(0f)
}