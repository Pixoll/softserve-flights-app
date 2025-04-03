package dev.softserve.travelin.ui.component
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.softserve.travelin.data.model.BookedTrip
import dev.softserve.travelin.data.model.Destination
import dev.softserve.travelin.data.model.Layover
import dev.softserve.travelin.data.model.Layovers
import dev.softserve.travelin.R

@Composable
fun BookedTripSection(bookedTrip: BookedTrip) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Upcoming",
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color(0xFF2E7D32), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Text(
                    text = bookedTrip.destinations.first().dateBooked,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = bookedTrip.destinations.first().departureAirport,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.departure_icon),
                        contentDescription = "Departure Icon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = bookedTrip.destinations.first().departureTime,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Text(text = "-------------->\n${bookedTrip.destinations.first().flightDuration}", color = Color.Gray)
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = bookedTrip.destinations.first().arrivalAirport,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.arrival_icon),
                        contentDescription = "Arrival Icon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = bookedTrip.destinations.first().arrivalTime,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${bookedTrip.destinations.first().airline} • ${bookedTrip.destinations.first().flightClass} • Direct",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Booking ID", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                Text(text = bookedTrip.bookingId, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
