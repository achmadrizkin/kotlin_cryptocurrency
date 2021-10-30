package com.example.cyptocurrencyapp.presentasion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cyptocurrencyapp.R

class MainActivity : AppCompatActivity() {
    // what is architectur MVVM -> View Model with Logic
    // clean acrhitectur -> use case

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}