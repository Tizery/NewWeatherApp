package com.example.newweatherapp

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    text: String,
    actionText: String,
    lenght: Int = Snackbar.LENGTH_INDEFINITE,
    action: (View) -> Unit
) {
    Snackbar.make(this, text, lenght).setAction(actionText, action).show()
}