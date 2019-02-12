package com.example.testdemo.weatherapp.extensions

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<Pair<K, V>> = map { Pair(it.key, it.value!!) }.toTypedArray()