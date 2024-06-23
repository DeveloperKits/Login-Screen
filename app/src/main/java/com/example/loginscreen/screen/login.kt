package com.example.loginscreen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreen.R
import com.example.loginscreen.component.InputTextField
import com.example.loginscreen.component.NormalText
import com.example.loginscreen.ui.theme.blackBg
import com.example.loginscreen.ui.theme.whiteBg

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = whiteBg)
            .padding(horizontal = 25.dp),
    ) {
        Column {
            Spacer(modifier = Modifier.height(30.dp))

            NormalText(
                text = stringResource(id = R.string.hello),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(5.dp))

            NormalText(
                text = stringResource(id = R.string.create_account),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20
            )

            Spacer(modifier = Modifier.height(30.dp))

            InputTextField(hint = "Email", value = "") {

            }
        }

    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen()
}