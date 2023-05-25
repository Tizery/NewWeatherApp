package com.example.newweatherapp.model.repository

import com.example.newweatherapp.model.WeatherLoader
import com.example.newweatherapp.model.entities.City
import com.example.newweatherapp.model.entities.Weather

class RepositoryImpl : Repository {

    override fun getWeatherFromServer(lat: Double, lon: Double): Weather {
        val dto = WeatherLoader.loadWeather(lat, lon)
        return Weather(
            temperature = dto?.fact?.temp ?: 0,
            feelsLike = dto?.fact?.feels_like ?: 0,
            condition = dto?.fact?.condition
        )
    }

    override fun getWeatherFromLocalStorageRussian() = City.getRussianCities()
    override fun getWeatherFromLocalStorageWorld() = City.getWorldCities()

}