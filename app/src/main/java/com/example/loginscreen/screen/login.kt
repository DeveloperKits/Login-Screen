package com.example.loginscreen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreen.R
import com.example.loginscreen.component.ButtonComponent
import com.example.loginscreen.component.CheckBoxField
import com.example.loginscreen.component.InputTextField
import com.example.loginscreen.component.NormalText
import com.example.loginscreen.component.PassInputTextField
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

            InputTextField(hint = "Name", icon = Icons.Default.Person) {

            }

            Spacer(modifier = Modifier.height(10.dp))

            InputTextField(hint = "Email", icon = Icons.Default.Email, keyboardType = KeyboardType.Email) {

            }

            Spacer(modifier = Modifier.height(10.dp))

            PassInputTextField(hint = "Password", icon = Icons.Default.Password) {

            }

            CheckBoxField(value = "You are agreed to our terms and conditions")

            Spacer(modifier = Modifier.height(50.dp))

            ButtonComponent(text = "Login") {
                
            }

        }

    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen()
}