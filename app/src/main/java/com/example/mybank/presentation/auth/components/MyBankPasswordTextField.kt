package com.example.mybank.presentation.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.R
import java.lang.Error

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBankPasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
    isError: Boolean = false,
    supportingText: String = "Password must be at least 6 characters long"
) {
    val showPassword = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        trailingIcon = {
            IconButton(
                onClick = { showPassword.value = !showPassword.value },
            ) {
                Icon(
                    painter = painterResource(id = if (!showPassword.value) R.drawable.closed_eye_icon else R.drawable.opened_eye_icon),
                    contentDescription = null,
                    tint = if(showPassword.value) Color(0xFF0E4259) else Color.Gray
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFECEFF7),
            unfocusedIndicatorColor = Color.LightGray,
            focusedIndicatorColor = Color(0xFF356C84),
            cursorColor = Color(0xFF0E4259),
            focusedLabelColor = Color(0xFF356C84),

            ),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(
                text = "Password",
                color = Color.Gray,
                fontSize = 16.sp
            )
        },
        singleLine = true,
        visualTransformation = if(showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    text = supportingText,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
        }
    )

}