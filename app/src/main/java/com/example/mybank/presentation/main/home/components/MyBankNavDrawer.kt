package com.example.mybank.presentation.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.R
import com.example.mybank.domain.model.User

@Composable
fun MyBankNavDrawer(
    modifier: Modifier = Modifier,
    onLogoutClick: () -> Unit,
    user: User
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color(0XFF356C84))
                .height(200.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.mybank),
                contentDescription = null,
                modifier = Modifier
                    .width(180.dp)
                    .height(180.dp)
                    .align(Alignment.TopCenter),
                tint = Color.White
            )
        }

        Column {
            Spacer(modifier = Modifier.height(250.dp))
            Divider()
            Text(
                text = "Name:",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_light))
            )
            Text(
                text = "${user.name + " " + user.surname}",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium))
            )
            Divider()
            Text(
                text = "Email:",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_light))
            )
            Text(
                text = "${user.email}",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium))
            )
            Divider()
        }
        Card(
            modifier = Modifier
                .border(
                    width = 1.dp, color = Color(0xFFC0C0C0),
                    shape = RoundedCornerShape(10.dp)
                )
                .width(100.dp)
                .height(40.dp)
                .align(Alignment.BottomStart)
                .clickable(
                    onClick = {
                        onLogoutClick()
                    }
                ),
            shape = RoundedCornerShape(size = 10.dp),
            CardDefaults.cardColors(
                containerColor = Color.Transparent
            )

        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logout),
                    contentDescription = "Logout",
                    modifier = Modifier
                        .width(13.dp)
                        .height(11.dp)
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "Logout",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 14.sp,
                )
            }


        }
    }

}