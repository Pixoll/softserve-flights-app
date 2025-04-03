package dev.softserve.travelin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.softserve.travelin.data.model.BookedTrip
import dev.softserve.travelin.data.model.Destination
import dev.softserve.travelin.data.model.Layover
import dev.softserve.travelin.data.model.Layovers
import dev.softserve.travelin.data.model.User
import dev.softserve.travelin.ui.component.BookedTripSection
import dev.softserve.travelin.ui.component.TripSearchBar
import dev.softserve.travelin.ui.component.UserInfo
import dev.softserve.travelin.ui.theme.TravelinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelinTheme {
        Greeting("Android")
    }
}*/
@Preview(showBackground = true)
@Composable
fun UserInfoScreen(){
    val user = User("Paul",2000,"D:\\Klotin\\SoftServer\\softserve-flights-app\\app\\src\\main\\res\\drawable\\img.png")

    UserInfo(user=user)
}


@Preview(showBackground = true)
@Composable
fun TripSearchBarScreen(){
    var searchQuery by rememberSaveable { mutableStateOf("") }
    Column {TripSearchBar(searchQuery=searchQuery,onSearchQueryChanged={searchQuery=it})
    /*Text("Where to go:$searchQuery", modifier =Modifier.padding(8.dp) )*/}
}
@Preview(showBackground = true)
@Composable
fun BookedTripSectionScreen(){
    val layover1 = Layover(
        departureLayoverAirport = "JFK",
        arrivalLayoverAirport = "LHR",
        departureLayoverTime = "2025-04-10T12:00",
        arrivalLayoverTime = "2025-04-10T14:30",
        flightDuration = "1h 30m"
    )

    val destination1 = Destination(
        dateBooked = "24 March 2024",
        departureAirport = "LAX",
        arrivalAirport = "CDG",
        departureTime = "05:30",
        arrivalTime = "07:00",
        airline = "Air France",
        flightClass = "Business",
        flightDuration = "1h 30m",
        layovers = Layovers(listOf(layover1))
    )

    val bookedTrip = BookedTrip(
        bookingId = "ABC12345",
        destinations = listOf(destination1)
    )
    BookedTripSection(bookedTrip)
}

