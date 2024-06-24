package com.example.loginscreen.app

import androidx.compose.runtime.mutableStateOf

sealed class Screen() {
    data object LoginScreen: Screen()
    data object TermsCondition: Screen()
}

object RouteManagement {
    val currentScreen = mutableStateOf<Screen>(Screen.LoginScreen)

    fun navigateTo(screen: Screen) {
        currentScreen.value = screen
    }
}