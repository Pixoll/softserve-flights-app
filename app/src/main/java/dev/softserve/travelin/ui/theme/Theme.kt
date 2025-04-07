package dev.softserve.travelin.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Seaweed70,
    secondary = MossGreen60,
    tertiary = Grey70,
    background = BackgroundDark,
    primaryContainer = ContainerBackgroundDark,
)

private val LightColorScheme = lightColorScheme(
    primary = Seaweed30,
    secondary = MossGreen30,
    tertiary = Grey30,
    background = BackgroundLight,
    primaryContainer = ContainerBackgroundLight,
)

val ColorScheme.primaryText
    @Composable
    get() = if (isSystemInDarkTheme()) TextPrimaryDark else TextPrimaryLight

val ColorScheme.invertedText
    @Composable
    get() = if (isSystemInDarkTheme()) TextPrimaryLight else TextPrimaryDark

val ColorScheme.secondaryText
    @Composable
    get() = if (isSystemInDarkTheme()) TextSecondaryDark else TextSecondaryLight

val ColorScheme.pointsText
    @Composable
    get() = if (isSystemInDarkTheme()) Yellow80 else Yellow50

val ColorScheme.ticketArrow
    @Composable
    get() = if (isSystemInDarkTheme()) TicketArrowDark else TicketArrowLight

@Composable
fun TravelinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
