package com.example.loginscreen.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginscreen.component.NormalText
import com.example.loginscreen.ui.theme.whiteBg

@Composable
fun TermsCondition() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = whiteBg)
            .padding(horizontal = 25.dp),
    ) {
        NormalText(text = "Terms and Conditions")
    }
}