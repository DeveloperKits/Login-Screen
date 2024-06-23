package com.example.loginscreen.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen.ui.theme.textColor
import com.example.loginscreen.ui.theme.textFieldColor

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
    value: String,
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
        modifier = Modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp)),
        placeholder = { Text(hint) },
        //leadingIcon = Icons.Default.Email,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = textColor,
            cursorColor = textColor,
            focusedBorderColor = textColor,
            focusedLabelColor = textColor,
        )
    )
}