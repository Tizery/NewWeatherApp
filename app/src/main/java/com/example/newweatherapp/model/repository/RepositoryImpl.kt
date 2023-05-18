package com.example.newweatherapp.model.repository

import com.example.newweatherapp.model.entities.Weather
import com.example.newweatherapp.model.entities.getRussianCities
import com.example.newweatherapp.model.entities.getWorldCities

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorageRussian() = getRussianCities()
    override fun getWeatherFromLocalStorageWorld() = getWorldCities()


}