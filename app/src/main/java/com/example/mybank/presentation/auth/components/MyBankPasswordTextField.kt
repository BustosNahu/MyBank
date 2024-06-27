package com.example.mybank.presentation.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBankPasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        trailingIcon = {
            Icon(painter = painterResource(id = R.drawable.closed_eye_icon),
                contentDescription = null)
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
        }
    )

}