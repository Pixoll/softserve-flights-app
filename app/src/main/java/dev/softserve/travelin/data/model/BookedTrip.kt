package dev.softserve.travelin.data.model

data class BookedTrip(
    val bookingId: String,
    val destinations: List<Destination>
) {
    /*val layover1 = Layover(
    departureLayoverAirport = "JFK",
    arrivalLayoverAirport = "LHR",
    departureLayoverTime = "2025-04-10T12:00",
    arrivalLayoverTime = "2025-04-10T14:30"
)

val destination1 = Destination(
    dateBooked = "2025-04-01",
    departureAirport = "LAX",
    arrivalAirport = "CDG",
    departureTime = "2025-04-10T08:00",
    arrivalTime = "2025-04-10T22:30",
    airline = "Air France",
    flightClass = "Business",
    layovers = Layovers(listOf(layover1))
)

val bookedTrip = BookedTrip(
    bookingId = "ABC12345",
    destinations = listOf(destination1)
)

println(bookedTrip)
*/
}