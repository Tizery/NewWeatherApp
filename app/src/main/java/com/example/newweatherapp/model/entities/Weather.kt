package com.example.newweatherapp.model.entities

import android.os.Parcelable
import com.example.newweatherapp.model.entities.City.Companion.getDefaultCity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
) : Parcelable
