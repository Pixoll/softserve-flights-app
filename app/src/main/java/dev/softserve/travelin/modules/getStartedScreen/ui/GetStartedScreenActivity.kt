package dev.softserve.travelin.modules.getStartedScreen.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.softserve.travelin.R
import dev.softserve.travelin.modules.getStartedScreen.ui.ui.theme.TravelinTheme

class GetStartedScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelinTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GetStartedScreenUI()
                }
            }
        }
    }
}


@Composable
fun BackgroundImages() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = "background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 160.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "app logo",
                modifier = Modifier.requiredSize(200.dp)
            )
        }
    }
}

@Composable
fun WhiteBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp, shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp), clip = false)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
            .padding(vertical = 32.dp, horizontal = 24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Ready to explore\nbeyond boundaries?",
                color = Color(android.graphics.Color.parseColor("#007A8C")),
                fontSize = 24.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 280.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.parseColor("#007A8C"))
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Your Journey Starts Here",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.vector_plane),
                    contentDescription = "Plane icon",
                    tint = Color.White
                )
            }
        }
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun GetStartedScreenUI() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {

        BackgroundImages()
        WhiteBox(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxHeight(0.32f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GetStartedScreenPreview() {
    TravelinTheme {
        GetStartedScreenUI()
    }
}
