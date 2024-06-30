package com.example.mybank.core.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mybank.R

@Composable
fun MyBankSuccessScreen(
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit,
    title: String = "Congratulations! Your account has been created successfully!",
    buttonTitle: String = "Finish",
    isVisible: Boolean,
) {

    val successLottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.success_animation))
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 300)
        )
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
                    text = title,
                    fontSize = 20.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    color = Color(0xFF0E4259),
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    modifier = Modifier
                        .padding(top = 100.dp)
                )
                LottieAnimation(
                    composition = successLottieComposition,
                    iterations = 1,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .size(280.dp)
                )


            }
            MyBankCustomButton(
                onClick = {
                    onContinueClick()
                },
                text = buttonTitle,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 120.dp)
            )
        }
    }


}
