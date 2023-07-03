package com.example.practice_type.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practice_type.data.DateTimeConverter
import com.example.practice_type.data.DrawerItemDao
import com.example.practice_type.data.NavigationDrawerItem

//クラスリファレンスというらしい↓NavigationDrawerItem::class
@Database(entities = [NavigationDrawerItem::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun drawerItemDao(): DrawerItemDao
}