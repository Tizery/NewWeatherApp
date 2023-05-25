package com.example.newweatherapp.ui.details

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newweatherapp.AppState
import com.example.newweatherapp.model.repository.Repository

class DetailsViewModel(val repository: Repository) : ViewModel(), LifecycleObserver {

    val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun loadData(lat: Double, lon: Double) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            val data = repository.getWeatherFromServer(lat, lon)
            liveDataToObserve.postValue(AppState.Success(listOf(data)))
        }.start()
    }
}