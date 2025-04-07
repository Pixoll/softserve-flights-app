package dev.softserve.travelin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.softserve.travelin.R

private val interFontFamily = FontFamily(
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_extra_light, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
    Font(R.font.inter_black, FontWeight.Black),

    Font(R.font.inter_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.inter_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.inter_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.inter_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.inter_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.inter_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.inter_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.inter_black_italic, FontWeight.Black, FontStyle.Italic),
)

private val defaultTypography = Typography()

val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = interFontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = interFontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = interFontFamily),
    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = interFontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = interFontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = interFontFamily),
    titleLarge = defaultTypography.titleLarge.copy(fontFamily = interFontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = interFontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = interFontFamily),
    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = interFontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = interFontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = interFontFamily),
    labelLarge = defaultTypography.labelLarge.copy(fontFamily = interFontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = interFontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = interFontFamily),
)
