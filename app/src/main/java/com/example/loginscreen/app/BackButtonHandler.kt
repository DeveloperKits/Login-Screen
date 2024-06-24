package com.example.loginscreen.app

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLifecycleOwner

private val LocalBackPress = staticCompositionLocalOf<OnBackPressedDispatcher?> { null}

private class ComposableBackNavigationHandler(enabled: Boolean) : OnBackPressedCallback(enabled) {
    lateinit var onBackPressed: () -> Unit
    override fun handleOnBackPressed() {
        onBackPressed()
    }

}

@Composable
internal fun SystemBackNavigation(onBackPressed: () -> Unit) {
    CompositionLocalProvider(

    ) {

    }
}