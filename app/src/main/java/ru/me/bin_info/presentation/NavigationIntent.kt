package ru.me.bin_info.presentation

sealed class NavigationIntent {
    data object Map : NavigationIntent()
    data object Url : NavigationIntent()
    data object Dial : NavigationIntent()
}