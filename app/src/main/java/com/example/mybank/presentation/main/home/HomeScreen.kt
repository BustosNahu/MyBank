package com.example.mybank.presentation.main.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController

) {
    HomeScreenChild(

    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreenChild(


) {
    Scaffold(
        topBar = {

        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Home Screen",
                Modifier.align(Alignment.Center)

            )
        }
    }

}