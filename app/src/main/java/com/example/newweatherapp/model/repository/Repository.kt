package com.example.newweatherapp.model.repository

import com.example.newweatherapp.model.entities.Weather

interface Repository {

    fun getWeatherFromServer() : Weather
    fun getWeatherFromLocalStorage() : Weather
}