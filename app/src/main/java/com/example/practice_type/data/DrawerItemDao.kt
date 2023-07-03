package com.example.practice_type.data

import androidx.room.*
import androidx.room.Dao
import androidx.room.Query
import com.example.practice_type.data.NavigationDrawerItem

@Dao
interface DrawerItemDao {
    @Query("select * from tasks order by created_at asc")
    fun getAll():MutableList<NavigationDrawerItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun post(task: NavigationDrawerItem)

    @Delete
    fun delete(task: NavigationDrawerItem)

    @Update
    fun updateNote(task: NavigationDrawerItem)
}