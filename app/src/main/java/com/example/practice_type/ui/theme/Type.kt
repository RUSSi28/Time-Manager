package com.example.practice_type.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_type.R

//previewでは使えないため、後ほどcomicに変える事
val Castelar = FontFamily(
    Font(R.font.castelar)
)
val Comic = FontFamily(
    Font(R.font.comic)
)
// Set of Material typography styles to start with
val Typography = Typography(
//     h1 = TextStyle(
//         fontFamily = Castelar,
//         fontWeight = FontWeight.Normal,
//         fontSize = 30.sp
//     )
    h1 = TextStyle(
        fontFamily = Comic,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),
    h2 = TextStyle(
        fontFamily = Comic,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = Comic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */