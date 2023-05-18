package com.example.newweatherapp.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val cityName : String,
    val lat : Double,
    val lon : Double
) : Parcelable
