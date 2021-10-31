package com.example.cyptocurrencyapp.presentasion

sealed class Screen(val route: String) {
    object CoinsListScreen: Screen("coins_list_screen")
    object CoinDetailScreen: Screen("coin_details_screen")
}
