package com.example.practice_type

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import com.example.practice_type.ui.theme.PrimaryColor
import com.example.practice_type.ui.theme.SubColor
import com.example.practice_type.ui.theme.SubSubColor

@Composable
fun MyTopAppBar(onNavIconClick: () -> Unit) {
//    var colorMain by remember { mutableStateOf(Color(0xFF25AEC9)) }
    Column(modifier = Modifier.background(PrimaryColor)) {
        TopAppBar(
            backgroundColor = PrimaryColor,
            title = { Text(text = "TimeManager", style = MaterialTheme.typography.h1) },
            navigationIcon = {
                IconButton(
                    onClick = {
                        onNavIconClick()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Open Navigation Drawer"
                    )
                }
                },
        )
    }

}