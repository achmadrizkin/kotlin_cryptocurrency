package com.example.cyptocurrencyapp.presentasion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cyptocurrencyapp.presentasion.coin_details.CoinDetailScreen
import com.example.cyptocurrencyapp.presentasion.coin_list.CoinListScreen
import com.example.cyptocurrencyapp.presentasion.ui.theme.CryptocurrencyApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // use for Hill to inject dependecy
class MainActivity : AppCompatActivity() {
    // what is architectur MVVM -> View Model with Logic
    // clean acrhitectur -> use case

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyApp {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinsListScreen.route) {
                        composable(
                            route = Screen.CoinsListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }

                        //
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}