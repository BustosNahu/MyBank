package com.example.mybank.presentation.main.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.core.ui.components.MyBankTopBar
import com.example.mybank.domain.model.Movement
import com.example.mybank.presentation.main.home.components.HomeEvents
import com.example.mybank.presentation.main.home.components.InteractiveItemComp
import com.example.mybank.presentation.main.home.components.TopAccountData
import com.example.mybank.presentation.main.home.components.movement.MovementsContainer

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()

) {
    HomeScreenChild(
        uiState = viewModel.state.collectAsStateWithLifecycle(),
        onEvent = viewModel::handleEvent,
        navigateToMovementDetail = {
            navController.navigate(ScreenRoutes.MovementDetailScreen.route)
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreenChild(
    uiState: State<HomeUiState>,
    onEvent: (HomeEvents) -> Unit,
    navigateToMovementDetail: () -> Unit = {}
) {
    LaunchedEffect (uiState.value.isSelectedMovementIdSaved){
        if(uiState.value.isSelectedMovementIdSaved){
            navigateToMovementDetail()
            onEvent(HomeEvents.ClearState)
        }
    }
    Scaffold(
        topBar = {
            MyBankTopBar(
                modifier = Modifier,
                title = "MyBank",
                leftIcon = R.drawable.ic_top_bar_menu,
                onLeftIconClick = {
                    //TODO: Implement Navigation drawer
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 55.dp)
                .background(Color(0xFFF4F5F7))
        ) {
            TopAccountData(
                userName = uiState.value.user?.name ?: ""
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                item {
                    Spacer(modifier = Modifier.width(10.dp))
                    InteractiveItemComp(interactiveItem = InteractiveItems.QrPay)
                    Spacer(modifier = Modifier.width(10.dp))
                    InteractiveItemComp(interactiveItem = InteractiveItems.Transfer)
                    Spacer(modifier = Modifier.width(10.dp))
                    InteractiveItemComp(interactiveItem = InteractiveItems.Deposit)
                    Spacer(modifier = Modifier.width(10.dp))
                    InteractiveItemComp(interactiveItem = InteractiveItems.AskForMoney)
                    Spacer(modifier = Modifier.width(10.dp))
                    InteractiveItemComp(interactiveItem = InteractiveItems.InsuranceAndGuarantee)
                    Spacer(modifier = Modifier.width(10.dp))
                    InteractiveItemComp(interactiveItem = InteractiveItems.PayTaxes)
                }
            }

            MovementsContainer(
                movements = uiState.value.user?.listOfMovements?: emptyList(),
                onMovementClick = {
                    onEvent(HomeEvents.OnMovementClicked(it))
                }
            )

        }
    }

}

