package dev.softserve.travelin.modules.getStartedScreen.ui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.softserve.travelin.R


@Composable
fun GetStartedScreenUI() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val screenHeight = maxHeight
        val screenWidth = maxWidth

        // Background
        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = screenHeight * 0.20f),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .aspectRatio(234f / 80f)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.30f)
                .align(Alignment.BottomCenter)
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    clip = false
                )
                .background(Color.White, shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .padding(horizontal = screenWidth * 0.05f, vertical = screenHeight * 0.03f)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(top = screenHeight * 0.03f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(screenHeight * 0.035f)
            ) {
                Text(
                    text = "Ready to explore\nbeyond boundaries?",
                    fontSize = (screenHeight.value * 0.035f).sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF007A8C),
                    textAlign = TextAlign.Center
                )

                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007A8C)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Your Journey Starts Here")
                    Icon(
                        painter = painterResource(id = R.drawable.vector_plane),
                        contentDescription = "Airplane icon",
                        modifier = Modifier
                            .size(screenHeight * 0.028f)
                            .padding(start = 4.dp)
                    )
                }
            }
        }
    }
}