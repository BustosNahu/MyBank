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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
) {
    RegisterScreenChild(
        onNameTextChange = {

        },
        navToLoginScreen = {
            navController.popBackStack()
        }
    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun RegisterScreenChild(
    onNameTextChange: (String) -> Unit,
    navToLoginScreen: () -> Unit,
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
                    text = "",
                    onValueChange = onNameTextChange,
                    label = "Name"
                )
                MyBankTextField(
                    text = "",
                    label = "Surname",
                    onValueChange = {

                    }
                )
                MyBankTextField(
                    text = "",
                    label = "Email",
                    onValueChange = {

                    }
                )
                MyBankPasswordTextField(
                    password = "",
                    onPasswordChange = {

                    }
                )

                MyBankCustomButton(
                    onClick = {
                        /*TODO*/
                    },
                    text = "Register",
                    modifier = Modifier.padding(top = 40.dp)
                )


            }

        }


    }
}


@Preview
@Composable
private fun RegisterScreenPrev() {
    RegisterScreenChild(
        onNameTextChange = {

        },
        navToLoginScreen = {}
    )
}