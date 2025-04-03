package dev.softserve.travelin.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.softserve.travelin.data.model.User
import coil.compose.AsyncImage
import androidx.compose.ui.res.painterResource
import dev.softserve.travelin.R
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import java.text.NumberFormat
import java.util.Locale

@Composable
fun UserInfo(user: User){
    Row(
        modifier = Modifier.run {
            fillMaxWidth()
                .background(Color(0xFF007A8C))
                .padding(8.dp)
        },
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (
            modifier = Modifier.weight(1f)
        ){
            Text(text = "Hi, ${user.name}",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White)

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                )
            {
                Box(modifier = Modifier.padding(1.dp)) {
                    AsyncImage(
                        model = user.imageUrl,
                        contentDescription = "User Image",
                        placeholder = painterResource(id = R.drawable.vectorpuntos),
                        modifier = Modifier
                            .size(14.dp)
                            .clip(CircleShape)
                    )
                    }
                val formattedPoints = NumberFormat.getNumberInstance(Locale.GERMANY).format(user.points)
                Text(text = "$formattedPoints points",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFFFC107))
            }

        }
        Box (modifier = Modifier
            .size(35.dp)
            .clip(CircleShape)
            .background(Color.Transparent)
            .padding(1.dp)
        ){
            AsyncImage(
            model = user.imageUrl,
            contentDescription = "User Image",
            placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)) }

    }
}