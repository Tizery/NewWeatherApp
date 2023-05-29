package com.example.newweatherapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newweatherapp.AppState
import com.example.newweatherapp.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val liveData = MutableLiveData<AppState>()

    fun getLiveData(): LiveData<AppState> = liveData

    fun getWeatherFromLocalSourceRussian() = getDataFromLocalSource(isRussian = true)
    fun getWeatherFromLocalSourceWorld() = getDataFromLocalSource(isRussian = false)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveData.value = AppState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            liveData.postValue(
                if (isRussian) {
                    AppState.Success(repository.getWeatherFromLocalStorageRussian())
                } else {
                    AppState.Success(repository.getWeatherFromLocalStorageWorld())
                }
            )
        }
    }
}