package com.example.loginscreen.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.loginscreen.screen.LoginScreen
import com.example.loginscreen.screen.TermsCondition
import com.example.loginscreen.ui.theme.whiteBg

@Composable
fun RouteMangerApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = whiteBg
    ) {
        Crossfade(targetState = RouteManagement.currentScreen, label = "") {
            when(it.value){
                Screen.LoginScreen -> LoginScreen()
                Screen.TermsCondition -> TermsCondition()
            }
        }
    }
}
