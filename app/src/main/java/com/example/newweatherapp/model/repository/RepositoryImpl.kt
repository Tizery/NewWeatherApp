package com.example.newweatherapp.model.repository

import com.example.newweatherapp.model.entities.Weather

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorage() = Weather()
}