package com.example.loginscreen.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen.app.RouteManagement
import com.example.loginscreen.app.Screen
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
    icon: ImageVector,
    iconColor: Color = textFieldColor,
    keyboardType: KeyboardType = KeyboardType.Text,
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
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
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
            Icon(imageVector = icon, contentDescription = null, tint = iconColor)
        },
        shape = RoundedCornerShape(10.dp)
    )
}

@Composable
fun PassInputTextField(
    hint: String,
    icon: ImageVector,
    iconColor: Color = textFieldColor,
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
            Icon(imageVector = icon, contentDescription = null, tint = iconColor)
        },
        trailingIcon = {
            val image = if (passwordVisible.value)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible.value) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = image, contentDescription = description)
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(10.dp),
    )
}


@Composable
fun CheckBoxField(value: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember { mutableStateOf(true) }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
            checkedState.value != checkedState.value
        })
        //NormalText(text = value, color = textColor, fontSize = 16, fontWeight = FontWeight.Normal, textAlign = TextAlign.Start)
        ClickableTexts()
    }
}

@Composable
fun ClickableTexts(){
    val initialTest = "You are agreed to our "
    val termCondition = "Terms and Conditions"

    val annotatedString = buildAnnotatedString {
        append(initialTest)
        withStyle(style = SpanStyle(color = textFieldColor)){
            pushStringAnnotation(tag = termCondition, annotation = termCondition)
            append(termCondition)
        }
    }

    ClickableText(text = annotatedString, onClick = {
        annotatedString.getStringAnnotations(it, it).firstOrNull()?.also {span ->
            Log.d("ClickableTexts", "Clicked on ${span.item}")
            RouteManagement.navigateTo(Screen.TermsCondition)
        }
    })
}

@Composable
fun ButtonComponent(text: String, onClick: () -> Unit){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFFA4D7FF), Color(0xFF8EB7FF))),
                    shape = RoundedCornerShape(15.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            NormalText(text = text, color = Color.White, fontSize = 18, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}

