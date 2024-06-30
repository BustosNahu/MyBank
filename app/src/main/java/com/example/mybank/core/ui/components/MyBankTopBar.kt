package com.example.mybank.core.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.R

@Composable
fun MyBankTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    onLeftIconClick: () -> Unit,
    leftIcon: Int = R.drawable.baseline_arrow_back_24
    ) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(Color.White)
    ) {
        IconButton(
            onClick = {
                onLeftIconClick()
            },
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp, top = 16.dp),
         ) {
            Icon(
                painter = painterResource(id = leftIcon),
                contentDescription = "Arrow back",

                )
        }

        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 16.dp),
            color = Color(0xFF0E4259),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter_medium))
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun MyBankTopBarPrev() {
    MyBankTopBar(
        onLeftIconClick = {}
    )
}