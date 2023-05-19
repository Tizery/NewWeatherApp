package com.example.newweatherapp.model.repository

import com.example.newweatherapp.model.entities.City
import com.example.newweatherapp.model.entities.Weather

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorageRussian() = City.getRussianCities()
    override fun getWeatherFromLocalStorageWorld() = City.getWorldCities()


}