package dev.softserve.travelin.data.model

data class Destination(
    val dateBooked: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val departureTime: String,
    val arrivalTime: String,
    val airline: String,
    val flightClass: String,
    val flightDuration: String,
    val layovers: Layovers = Layovers()
) {
}