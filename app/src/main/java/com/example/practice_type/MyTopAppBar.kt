package com.example.practice_type

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.practice_type.ui.theme.PrimaryColor

@Composable
fun MyTopAppBar(onNavIconClick: () -> Unit) {
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