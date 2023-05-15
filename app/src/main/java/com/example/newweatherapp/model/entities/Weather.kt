package com.example.newweatherapp.model.entities

data class Weather(
    val cityName: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
)

fun getDefaultCity() = City("Москва", 55.755826, 37.617299900000035)
