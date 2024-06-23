package com.example.loginscreen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen.ui.theme.textColor

@Composable
fun NormalText(
    text: String,
    color: Color = textColor,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        color = color,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}

@Composable
fun InputTextField(
    hint: String,
    icon: ImageVector,
    onValueChange: (String) -> Unit
){
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onValueChange(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(hint) },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = textColor,
            cursorColor = textColor,
            focusedBorderColor = textColor,
            focusedLabelColor = textColor,
        ),
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = null)
        },
        shape = RoundedCornerShape(10.dp)
    )
}

@Composable
fun PassInputTextField(
    hint: String,
    icon: ImageVector,
    onValueChange: (String) -> Unit
){
    val textValue = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onValueChange(it)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(hint) },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = textColor,
            cursorColor = textColor,
            focusedBorderColor = textColor,
            focusedLabelColor = textColor,
        ),
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = null)
        },
        trailingIcon = {
            val image = if (passwordVisible.value)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible.value) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = image, description)
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(10.dp),
    )
}