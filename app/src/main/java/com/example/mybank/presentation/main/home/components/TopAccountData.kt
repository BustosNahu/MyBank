package com.example.mybank.presentation.main.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
fun TopAccountData(
    modifier: Modifier = Modifier,
    userName: String,
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .background(Color(0XFF356C84))
                .fillMaxWidth()
                .height(200.dp),
        ) {
            Column(
                Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Hello $userName!",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold))
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .clickable {
                            //TODO: Navigate to MyBank Club
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "You have 0 points MyBank Club",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.inter_light)),
                        fontSize = 12.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }

            }
        }
        DebitCard(modifier = Modifier.padding(top = 100.dp))

    }

}
