package com.example.mybank.presentation.main.details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.core.ui.components.MyBankTopBar

@Composable
fun MovementDetailScreen(
    navController: NavController,
    viewModel: MovementDetailViewModel = hiltViewModel(),
) {
    MovementDetailScreenChild(
        uiState = viewModel.state.collectAsStateWithLifecycle(),
        navigateToPreviousScreen = {
            navController.popBackStack()
        }
    )


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovementDetailScreenChild(
    uiState: State<MovementDetailUiState>,
    navigateToPreviousScreen: () -> Unit,
) {
    Scaffold(
        topBar = {
            MyBankTopBar(
                onLeftIconClick = {
                    navigateToPreviousScreen()
                },
                title = "Movement Detail"
            )
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 75.dp)
        ) {
            Column(
                Modifier
                    .background(
                        Color(0XFF356C84),
                        shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                    )
                    .height(200.dp)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Transfer NRO: #${uiState.value.movement?.id}",
                    color = Color.White,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "$${uiState.value.movement?.amount}",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold))
                )
                Text(
                    text = uiState.value.movement?.date ?: "",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_light))
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            IconButton(
                onClick = {
                   //TODO: Add share Movement functionality
                },
                Modifier.align(Alignment.CenterHorizontally),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.share_icon),
                    contentDescription = "Share Movement",
                    modifier = Modifier
                        .size(60.dp),
                    tint = Color(0XFF356C84)
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Divider()
                Text(
                    text = "Type of Movement:",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_light))
                )
                Text(
                    text = uiState.value.movement?.typeOfMovement ?: "",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )
                Divider()
                Text(
                    text = "Sent by:",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_light))
                )
                Text(
                    text = uiState.value.user?.name ?: "",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )
                Divider()
                Text(
                    text = "Bank:",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_light))
                )
                Text(
                    text = "MyBank",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )
                Divider()


            }


        }


    }


}
