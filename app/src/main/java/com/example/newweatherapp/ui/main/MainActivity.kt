package com.example.newweatherapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newweatherapp.R
import com.example.newweatherapp.ui.details.DetailsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}