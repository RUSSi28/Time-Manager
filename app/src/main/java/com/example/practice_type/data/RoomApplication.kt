package com.example.practice_type.data

import android.app.Application
import androidx.room.Room

class RoomApplication : Application() {
    companion object {
        lateinit var database: AppDatabase
    }


    //ここでデータベースができてるはずテーブル名tasks
    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks"
        ).build()
    }
}