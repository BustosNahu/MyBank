package com.example.mybank.presentation.main.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.mybank.R
import com.example.mybank.presentation.main.home.InteractiveItems

@Composable
fun InteractiveItemComp(
    modifier: Modifier = Modifier,
    interactiveItem: InteractiveItems,
) {
    Column(
        modifier = modifier
            .clickable {
                //TODO: Navigate to respective screen for example (interactiveItem.route)
            }
            .clip(RoundedCornerShape(5.dp))
            .height(100.dp)
            .width(70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier
                .height(50.dp)
                .width(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = interactiveItem.icon),
                contentDescription = null,
                tint = Color(0xFF0E4259),
                modifier = Modifier.size(35.dp)
            )
        }
        Text(
            text = interactiveItem.title,
            color = Color(0xFF0E4259),
            fontSize = 11.sp,
            fontFamily = FontFamily(Font(R.font.inter_light)),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.width(80.dp),
            lineHeight = 14.sp
        )
    }

}


@Preview
@Composable
private fun InteractiveItemCompPrev() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        InteractiveItemComp(interactiveItem = InteractiveItems.Transfer)

    }
}