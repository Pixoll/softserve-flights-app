package dev.softserve.travelin.data.model

data class Layover(
val departureLayoverAirport: String,
val arrivalLayoverAirport: String,
val departureLayoverTime: String,
val arrivalLayoverTime: String,
    val flightDuration: String
) {
}