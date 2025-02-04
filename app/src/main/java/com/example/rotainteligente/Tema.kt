package com.example.busapp.ui.theme  // Ajuste este pacote para corresponder à estrutura do seu projeto

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Defina suas cores aqui
private val Purple80 = androidx.compose.ui.graphics.Color(0xFFD0BCFF)
private val PurpleGrey80 = androidx.compose.ui.graphics.Color(0xFFCCC2DC)
private val Pink80 = androidx.compose.ui.graphics.Color(0xFFEFB8C8)

private val Purple40 = androidx.compose.ui.graphics.Color(0xFF6650a4)
private val PurpleGrey40 = androidx.compose.ui.graphics.Color(0xFF625b71)
private val Pink40 = androidx.compose.ui.graphics.Color(0xFF7D5260)

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    // Você pode adicionar mais estilos de texto aqui
)

@Composable
fun BusAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

