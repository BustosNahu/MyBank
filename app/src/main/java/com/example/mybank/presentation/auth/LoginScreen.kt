package com.example.mybank.presentation.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.mybank.core.navigation.ScreenRoutes

@Composable
fun LoginScreen(
    navController: NavController,

) {
    LoginScreenChild(

    )
}



@Composable
private fun LoginScreenChild(

    ) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Login Screen",
            modifier = Modifier.align(Alignment.Center))
    }

}

@Preview
@Composable
private fun LoginScreenPrev() {
    LoginScreenChild()
}