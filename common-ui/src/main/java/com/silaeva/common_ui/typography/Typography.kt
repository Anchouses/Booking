package com.silaeva.common_ui.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

object Typography {
    val title = TextStyle(
        fontSize = 22.sp,
        lineHeight = 26.4.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF000000),
    )
    val description = TextStyle(
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        fontWeight = FontWeight(400),
        color = Color(0xE5000000),
    )
    val priceLarge = TextStyle(
        fontSize = 30.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight(600),
        color = Color(0xFF000000),
    )
    val addressBlue = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.8.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF0D72FF),
    )
    val bodySecondary = TextStyle(
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF828796)
    )
    val tagsSecondary = TextStyle(
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF828796),
        textAlign = TextAlign.Center,
    )
    val tagsPrimary = TextStyle(
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF0D72FF),
        textAlign = TextAlign.Center,
    )
    val buttonPrimary = TextStyle(
        fontSize = 16.sp,
        lineHeight = 17.6.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFFFFFFFF),
        textAlign = TextAlign.Center,
        letterSpacing = 0.1.sp,
    )
    val tagsAccent = TextStyle(
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFFFFA800),
        textAlign = TextAlign.Center,
    )
    val aboutButtonTitle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF2C3035),
    )
    val aboutButtonDescription = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.8.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF828796),
    )
}