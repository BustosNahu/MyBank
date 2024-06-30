package com.example.mybank.presentation.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.R

@Composable
fun DebitCard(
    modifier: Modifier = Modifier,


    ) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp)
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0E4259),
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.visa_icon),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(55.dp)
            )
            Text(
                text = "Debit Card",
                color = Color.LightGray,
                fontFamily = FontFamily(Font(R.font.inter_light)),
                fontSize = 12.sp,
            )

            Spacer(modifier = Modifier.height(0.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    textAlign = TextAlign.Justify,
                    fontSize = 16.sp
                )
                Text(
                    text = "24,656.56",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    fontSize = 26.sp,
                    textAlign = TextAlign.Justify
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row {
                Text(text = "...3745",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.weight(1f)
                )
                Text(text = "17/8",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                )

            }


        }
    }

}

@Preview
@Composable
private fun DebitCardPrev() {
    Column {
        Spacer(modifier = Modifier.height(300.dp))
        DebitCard()
    }

}