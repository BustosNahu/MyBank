package com.example.mybank.presentation.main.home.components.movement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.R
import com.example.mybank.domain.model.Movement

@Composable
fun MovementsContainer(
    modifier: Modifier = Modifier,
    movements: List<Movement>,
    onMovementClick: (Movement) -> Unit
) {

    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "My Movements",
            fontSize = 20.sp,
            color = Color(0xFF0E4259),
            fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
        )
        Divider(Modifier.fillMaxWidth(), thickness = 1.dp, color = Color(0xFF0E4259))
        if (movements.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "No movements yet...",
                    fontSize = 16.sp,
                    color = Color(0xFF0E4259),
                    fontFamily = FontFamily(Font(R.font.inter_light)),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Icon(
                    painter = painterResource(id = R.drawable.cross_icon),
                    contentDescription = null,
                    tint = Color(0xFF0E4259),
                    modifier = Modifier.size(40.dp)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(10.dp)
            ) {
                itemsIndexed(movements) { index, movement ->
                    MovementCard(
                        movement = movement,
                        onClick = {
                            onMovementClick(movement)
                        }
                    )
                }

            }
        }
    }


}