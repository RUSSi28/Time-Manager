package com.example.practice_type

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class NavigationDrawerItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val projectName: String = "",
    var time: Int = 0,
    //Painter型は対応してないみたい
//    val image: Painter,
//    val style: TextStyle,
//    val showUnreadBubble: Boolean = false,

    val created_at: Date = Date()
)
