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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.core.ui.components.MyBankCustomButton
import com.example.mybank.presentation.auth.components.MyBankPasswordTextField
import com.example.mybank.presentation.auth.components.MyBankTextField
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
    ) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()

    LoginScreenChild(
        uiState = uiState,
        navToRegisterScreen = {
            navController.navigate(ScreenRoutes.RegisterScreen.route)
        },
        navToHomeScreen = {
            navController.navigate(ScreenRoutes.HomeScreen.route){
                popUpTo(ScreenRoutes.LoginScreen.route) {
                    inclusive = true
                }
            }
        },
        onEmailTextChange = viewModel::onEmailTextChange,
        onPasswordTextChange = viewModel::onPasswordTextChange,
        onLoginClick = viewModel::validateUserCredentials

    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun LoginScreenChild(
    uiState: State<LoginUiState>,
    onEmailTextChange: (String) -> Unit,
    onPasswordTextChange: (String) -> Unit,
    navToRegisterScreen: () -> Unit,
    navToHomeScreen: () -> Unit,
    onLoginClick: () -> Unit
) {
    LaunchedEffect(uiState.value.isLoginSuccess) {
        if(uiState.value.isLoginSuccess) navToHomeScreen()
    }

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
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = "Image",
                modifier = Modifier
                    .size(270.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            MyBankTextField(
                text = uiState.value.email,
                onValueChange = onEmailTextChange,
                label = "Email",
                isError = uiState.value.isError,
            )
            MyBankPasswordTextField(
                password = uiState.value.password,
                onPasswordChange = onPasswordTextChange,
                isError = uiState.value.isError,
                supportingText = "Please enter a valid password"
            )
            Spacer(modifier = Modifier.height(50.dp))
            MyBankCustomButton(
                onClick = {
                    onLoginClick()
                },
                text = "Login",
                isLoading = uiState.value.isLoading
            )
            Spacer(modifier = Modifier.height(10.dp))
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
