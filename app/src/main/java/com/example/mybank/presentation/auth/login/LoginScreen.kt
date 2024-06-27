package com.example.mybank.presentation.auth.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.core.ui.components.MyBankCustomButton
import com.example.mybank.presentation.auth.components.MyBankPasswordTextField
import com.example.mybank.presentation.auth.components.MyBankTextField

@Composable
fun LoginScreen(
    navController: NavController,

    ) {
    LoginScreenChild(
        navToRegisterScreen = {
            navController.navigate(ScreenRoutes.RegisterScreen.route)
        }
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun LoginScreenChild(
    emailText: String = "",
    onEmailTextChange: (String) -> Unit = {},
    passwordText: String = "",
    onPasswordTextChange: (String) -> Unit = {},
    navToRegisterScreen: () -> Unit = {},
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Login to",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter_light)),
            )
            Icon(
                painter = painterResource(id = R.drawable.mybank),
                contentDescription = "My Bank",
                tint = Color(0xFF0E4259),
                modifier = Modifier.size(170.dp)
            )

        }
        Column(
            Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = "Image",
                modifier = Modifier
                    .size(270.dp)
            )
            MyBankTextField(
                text = emailText,
                onValueChange = onEmailTextChange,
            )
            MyBankPasswordTextField(
                password = passwordText,
                onPasswordChange = onPasswordTextChange,
            )
            Spacer(modifier = Modifier.height(40.dp))
            MyBankCustomButton(
                onClick = {
                    /*TODO*/
                },
                text = "Login",
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            Row(
                Modifier
                    .padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have account?")
                Text(
                    text = "Sing up",
                    color = Color(0xFF0003FF),
                    modifier = Modifier
                        .clickable {
                            navToRegisterScreen()
                        }
                        .padding(start = 4.dp),
                    textDecoration = TextDecoration.Underline

                )

            }

        }
    }
}


@Preview
@Composable
private fun LoginScreenPrev() {
    LoginScreenChild()
}