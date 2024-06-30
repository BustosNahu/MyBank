package com.example.mybank.presentation.main.home.components.movement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.R
import com.example.mybank.domain.model.Movement

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovementCard(
    movement: Movement,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {
            onClick()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = movement.description.uppercase(),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
            )

            Row {
                Text(
                    text = movement.date,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.inter_light)),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "$${movement.amount}",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                )

            }
        }

    }


}