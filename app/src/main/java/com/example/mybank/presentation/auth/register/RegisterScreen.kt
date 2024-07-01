package com.example.mybank.presentation.auth.register

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.core.ui.components.MyBankSuccessScreen
import com.example.mybank.core.ui.components.MyBankCustomButton
import com.example.mybank.core.ui.components.MyBankTopBar
import com.example.mybank.core.util.FunctionUtils.createTempPictureUri
import com.example.mybank.presentation.auth.components.MyBankPasswordTextField
import com.example.mybank.presentation.auth.components.MyBankTextField
import com.airbnb.lottie.compose.LottieAnimation

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
            navController.navigate(ScreenRoutes.HomeScreen.route) {
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
                onEvents(RegisterEvents.OnSavePicAndRegisterUser(tempPhotoUri))
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
        } else if (uiState.value.isCameraLaunch && !hasCameraPermission) {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }
    StepTwoOfRegistration(
        isVisible = uiState.value.stepTwoOfRegistration,
        onContinueClick = {
            onEvents(RegisterEvents.ContinueWithRegistrationStep2)
        },
    )

    MyBankSuccessScreen(
        isVisible = uiState.value.isRegisterSuccess,
        onContinueClick = {
            navToHomeScreen()
        }
    )
}

@Composable
fun StepTwoOfRegistration(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    onContinueClick: () -> Unit,
) {
    val successLottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.success))


    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 300)
        ),
    ) {
        Box(
            modifier = modifier
                .padding(16.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Now go to for your Identification and take a photo",
                    fontSize = 20.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    color = Color(0xFF0E4259),
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    modifier = Modifier
                        .padding(top = 100.dp)
                )



            }
            MyBankCustomButton(
                onClick = {
                    onContinueClick()
                },
                text = "Take Photo",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 120.dp)
            )
            LottieAnimation(
                composition = successLottieComposition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}
