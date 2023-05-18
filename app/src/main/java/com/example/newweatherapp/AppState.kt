package com.example.newweatherapp

import com.example.newweatherapp.model.entities.Weather

sealed class AppState{
    data class Success(val weatherData : List<Weather>) : AppState()
    data class Error(val error : Throwable) : AppState()
    object Loading : AppState()
}

