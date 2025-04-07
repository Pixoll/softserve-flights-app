package dev.softserve.travelin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.softserve.travelin.ui.theme.TravelinTheme
import dev.softserve.travelin.ui.theme.invertedText
import dev.softserve.travelin.ui.theme.pointsText
import dev.softserve.travelin.ui.theme.primaryText
import dev.softserve.travelin.ui.theme.secondaryText
import dev.softserve.travelin.ui.theme.ticketArrow

class FlightTicketShape(
    val cornerSize: Dp,
    val indentSize: Dp,
    val indentY: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val cornerRadius = with(density) { cornerSize.toPx() }
        val indentRadius = with(density) { indentSize.toPx() }
        val indentY = size.height - cornerRadius - with(density) {
            if (indentY < 0.dp) -indentY.toPx() else size.height - indentY.toPx()
        }

        val path = Path().apply {
            moveTo(cornerRadius, 0f)

            // top edge and top-right corner
            lineTo(size.width - cornerRadius, 0f)
            arcTo(
                rect = Rect(
                    left = size.width - cornerRadius * 2,
                    top = 0f,
                    right = size.width,
                    bottom = cornerRadius * 2,
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false,
            )

            // right edge until indent
            lineTo(size.width, indentY)

            // right indent
            lineTo(size.width - indentRadius, indentY)
            arcTo(
                rect = Rect(
                    left = size.width - indentRadius * 2,
                    top = indentY,
                    right = size.width,
                    bottom = indentY + indentRadius * 2,
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false,
            )
            lineTo(size.width, indentY + indentRadius * 2)

            // remaining right edge bottom-right corner
            lineTo(size.width, size.height - cornerRadius)
            arcTo(
                rect = Rect(
                    left = size.width - cornerRadius * 2,
                    top = size.height - cornerRadius * 2,
                    right = size.width,
                    bottom = size.height,
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false,
            )

            // bottom edge and bottom-left corner
            lineTo(cornerRadius, size.height)
            arcTo(
                rect = Rect(
                    left = 0f,
                    top = size.height - cornerRadius * 2,
                    right = cornerRadius * 2,
                    bottom = size.height,
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false,
            )

            // left edge until indent
            lineTo(0f, indentY + indentRadius * 2)

            // left indent
            lineTo(indentRadius, indentY + indentRadius * 2)
            arcTo(
                rect = Rect(
                    left = 0f,
                    top = indentY,
                    right = indentRadius * 2,
                    bottom = indentY + indentRadius * 2,
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false,
            )
            lineTo(0f, indentY)

            // remaining left edge and top-left corner
            lineTo(0f, cornerRadius)
            arcTo(
                rect = Rect(
                    left = 0f,
                    top = 0f,
                    right = cornerRadius * 2,
                    bottom = cornerRadius * 2,
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false,
            )

            close()
        }

        return Outline.Generic(path)
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    val primaryColor = MaterialTheme.colorScheme.primary

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val centerX1 = size.width / 2
        val centerY1 = 55.dp.toPx()
        val radiusX1 = size.width * 0.65f
        val radiusY1 = 200.dp.toPx()

        rotate(degrees = 13.6f, pivot = Offset(centerX1, centerY1)) {
            drawOval(
                color = primaryColor,
                topLeft = Offset(centerX1 - radiusX1, centerY1 - radiusY1),
                size = Size(radiusX1 * 2, radiusY1 * 2),
            )
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        // Header with user info
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Hi, Paul",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.invertedText,
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_points),
                        contentDescription = "Points Icon",
                        modifier = Modifier.height(20.dp),
                        tint = MaterialTheme.colorScheme.pointsText,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "2.000 points",
                        color = MaterialTheme.colorScheme.pointsText,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Search bar
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search Icon",
                        modifier = Modifier.height(18.dp),
                        tint = MaterialTheme.colorScheme.tertiary,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        "Where to go?",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                }
            },
            textStyle = MaterialTheme.typography.titleMedium,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .border(1.dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(10.dp)),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Booking info card
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            shape = FlightTicketShape(10.dp, 8.dp, (-40).dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4f)),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(12.dp, FlightTicketShape(10.dp, 8.dp, (-40).dp)),
        ) {
            Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp)) {
                val tertiaryColor = MaterialTheme.colorScheme.tertiary

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.background(
                            MaterialTheme.colorScheme.secondary,
                            RoundedCornerShape(1000.dp)
                        ),
                    ) {
                        Text(
                            "Upcoming",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.invertedText,
                            modifier = Modifier.padding(8.dp, 4.dp),
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "24 March 2024",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.secondaryText,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            "CGK",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primaryText,
                        )
                        Text(
                            "05:30",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.tertiary,
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_departure),
                        contentDescription = "Departure Icon",
                        tint = MaterialTheme.colorScheme.primaryText,
                        modifier = Modifier
                            .height(18.dp)
                            .padding(top = 2.dp),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f),
                    ) {
                        val ticketArrowColor = MaterialTheme.colorScheme.ticketArrow
                        val dashLength = 3.dp
                        val arrowLength = 3.dp
                        val stokeWidth = 3f

                        Canvas(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp, bottom = 4.dp, start = 38.dp, end = 38.dp)
                        ) {
                            drawLine(
                                color = ticketArrowColor,
                                start = Offset.Zero,
                                end = Offset(size.width, 0f),
                                cap = StrokeCap.Round,
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(dashLength.toPx(), dashLength.toPx())
                                ),
                                strokeWidth = stokeWidth,
                            )
                            drawLine(
                                color = ticketArrowColor,
                                start = Offset(size.width, 0f),
                                end = Offset(size.width - arrowLength.toPx(), -arrowLength.toPx()),
                                strokeWidth = stokeWidth,
                            )
                            drawLine(
                                color = ticketArrowColor,
                                start = Offset(size.width, 0f),
                                end = Offset(size.width - arrowLength.toPx(), arrowLength.toPx()),
                                strokeWidth = stokeWidth,
                            )
                        }
                        Text(
                            "1h30m",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.tertiary,
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrival),
                        contentDescription = "Arrival Icon",
                        tint = MaterialTheme.colorScheme.primaryText,
                        modifier = Modifier
                            .height(18.dp)
                            .padding(top = 2.dp),
                    )
                    Spacer(modifier = Modifier.width(6.dp))

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            "DPS",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primaryText,
                        )
                        Text(
                            "06:30",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.tertiary,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "Sentosa Air • Economy • Direct",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.secondaryText,
                )
                Spacer(modifier = Modifier.height(14.dp))
                Canvas(modifier = Modifier.fillMaxWidth()) {
                    drawLine(
                        color = tertiaryColor,
                        start = Offset(1.dp.toPx(), 0f),
                        end = Offset(size.width - 1.dp.toPx(), 0f),
                        alpha = 0.4f
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Booking ID",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.secondaryText,
                    )
                    Text(
                        "ZEEBAW",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.secondaryText,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation icons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_flight),
                contentDescription = "Flights",
                tint = MaterialTheme.colorScheme.secondary,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_hotel),
                contentDescription = "Hotels",
                tint = MaterialTheme.colorScheme.secondary,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_train),
                contentDescription = "Trains",
                tint = MaterialTheme.colorScheme.secondary,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_ferry),
                contentDescription = "Ferry",
                tint = MaterialTheme.colorScheme.secondary,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_bus),
                contentDescription = "Bus",
                tint = MaterialTheme.colorScheme.secondary,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Journey together section
        Text("Journey together", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Example journey card
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.journey_image),
                        contentDescription = "Journey Image",
                        modifier = Modifier.height(100.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Mount Bromo", fontWeight = FontWeight.Bold)
                    Text("Volcano in East Java")
                    Text("4.9")
                    Text("Start from $150/pax")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            // Another journey card
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.journey_image),
                        contentDescription = "Journey Image",
                        modifier = Modifier.height(100.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Labengki Sombori", fontWeight = FontWeight.Bold)
                    Text("Islands in Sulawesi")
                    Text("4.8")
                    Text("Start from $250/pax")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    TravelinTheme {
        Home()
    }
}
