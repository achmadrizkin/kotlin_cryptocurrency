package com.example.cyptocurrencyapp.presentasion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.cyptocurrencyapp.R
import com.example.cyptocurrencyapp.presentasion.ui.theme.CryptocurrencyApp

class MainActivity : AppCompatActivity() {
    // what is architectur MVVM -> View Model with Logic
    // clean acrhitectur -> use case

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyApp {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}