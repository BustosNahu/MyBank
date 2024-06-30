package com.example.mybank.presentation.auth.register

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.core.ui.MyBankSuccessScreen
import com.example.mybank.core.ui.components.MyBankCustomButton
import com.example.mybank.core.ui.components.MyBankTopBar
import com.example.mybank.core.util.FunctionUtils.createTempPictureUri
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
        onEvents = viewModel::handleEvents,
        navToHomeScreen = {
            navController.navigate(ScreenRoutes.HomeScreen.route){
                popUpTo(ScreenRoutes.LoginScreen.route) {
                    inclusive = true
                }
            }
        }

    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun RegisterScreenChild(
    uiState: State<RegisterUiState>,
    navToLoginScreen: () -> Unit,
    onEvents: (RegisterEvents) -> Unit,
    navToHomeScreen: () -> Unit
) {
    var tempPhotoUri by remember { mutableStateOf(value = Uri.EMPTY) }
    val context = LocalContext.current
    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            hasCameraPermission = isGranted
        }
    LaunchedEffect(key1 = true) {
        if (!hasCameraPermission) {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    val cameraLaunch =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicture()) {
            if (it) {
                Log.d("RegisterScreen", "Camera launched $tempPhotoUri")
                onEvents(RegisterEvents.OnSavePicAndRegisterUser("tempPhotoUri"))
            }
        }



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
                Image(
                    painter = painterResource(id = R.drawable.register_image),
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
                    onValueChange = { onEvents(RegisterEvents.OnEmailTextChange(it)) },
                    isError = uiState.value.isError
                )
                MyBankPasswordTextField(
                    password = uiState.value.password,
                    onPasswordChange = { onEvents(RegisterEvents.OnPasswordTextChange(it)) },
                    isError = uiState.value.isError
                )

                MyBankCustomButton(
                    onClick = {
                        onEvents(RegisterEvents.ContinueWithRegistration)
                    },
                    text = "Next",
                    modifier = Modifier.padding(top = 40.dp),
                    isLoading = uiState.value.isLoading
                )

            }
        }
        if (uiState.value.isCameraLaunch && hasCameraPermission) {
            LaunchedEffect(Unit) {
                tempPhotoUri = context.createTempPictureUri()
                cameraLaunch.launch(tempPhotoUri)
            }
        } else if (uiState.value.isCameraLaunch && !hasCameraPermission){
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    MyBankSuccessScreen(
        isVisible = uiState.value.isRegisterSuccess,
        onContinueClick = {
            navToHomeScreen()
        }
    )
}
