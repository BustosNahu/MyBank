package com.example.mybank.presentation.auth.register

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.core.ui.components.MyBankCustomButton
import com.example.mybank.core.ui.components.MyBankTopBar
import com.example.mybank.presentation.auth.components.MyBankPasswordTextField
import com.example.mybank.presentation.auth.components.MyBankTextField

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()
    RegisterScreenChild(
        uiState = uiState,
        navToLoginScreen = {
            navController.popBackStack()
        },
        onEvents = viewModel::handleEvents

    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun RegisterScreenChild(
    uiState: State<RegisterUiState>,
    navToLoginScreen: () -> Unit,
    onEvents: (RegisterEvents) -> Unit
) {
    Scaffold(
        topBar = {
            MyBankTopBar(
                title = "Register",
                onLeftIconClick = {
                    navToLoginScreen()
                }
            )
        }
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 70.dp),
            verticalArrangement = Arrangement.spacedBy(13.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(painter = painterResource(id = R.drawable.register_image),
                    contentDescription = null,
                )
                MyBankTextField(
                    text = uiState.value.name,
                    onValueChange = { onEvents(RegisterEvents.OnNameTextChange(it)) },
                    label = "Name",
                    isError = uiState.value.isError,
                    supportingText = "This field is required"
                )
                MyBankTextField(
                    text = uiState.value.surname,
                    label = "Surname",
                    onValueChange = { onEvents(RegisterEvents.OnSurnameTextChange(it)) },
                    isError = uiState.value.isError,
                    supportingText = "This field is required"
                )
                MyBankTextField(
                    text = uiState.value.email,
                    label = "Email",
                    onValueChange = { onEvents(RegisterEvents.OnEmailTextChange(it))},
                    isError = uiState.value.isError
                )
                MyBankPasswordTextField(
                    password = uiState.value.password,
                    onPasswordChange = { onEvents(RegisterEvents.OnPasswordTextChange(it))},
                    isError = uiState.value.isError
                )

                MyBankCustomButton(
                    onClick = {
                        onEvents(RegisterEvents.OnRegisterClick)
                    },
                    text = "Register",
                    modifier = Modifier.padding(top = 40.dp)
                )


            }

        }


    }
}
