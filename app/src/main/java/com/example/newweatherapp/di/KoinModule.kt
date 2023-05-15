package com.example.newweatherapp.di

import com.example.newweatherapp.model.repository.Repository
import com.example.newweatherapp.model.repository.RepositoryImpl
import com.example.newweatherapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }

    viewModel { MainViewModel(get()) }

}