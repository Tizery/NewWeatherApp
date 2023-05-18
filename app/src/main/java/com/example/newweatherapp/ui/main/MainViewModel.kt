package com.example.newweatherapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newweatherapp.AppState
import com.example.newweatherapp.model.repository.Repository
import java.lang.Thread.sleep

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val liveData = MutableLiveData<AppState>()

    fun getLiveData(): LiveData<AppState> = liveData

    fun getWeatherFromLocalSourceRussian() = getDataFromLocalSource(isRussian = true)
    fun getWeatherFromLocalSourceWorld() = getDataFromLocalSource(isRussian = false)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveData.value = AppState.Loading
        Thread {
            sleep(1000)
            liveData.postValue(
                if (isRussian) {
                    AppState.Success(repository.getWeatherFromLocalStorageRussian())
                } else {
                    AppState.Success(repository.getWeatherFromLocalStorageWorld())
                }
            )
        }.start()
    }
}