package com.toscano.proyectofinal.data.local.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.toscano.proyectofinal.data.local.database.dao.UsersDAO
import com.toscano.proyectofinal.data.local.database.entities.UsersDB

@Database(entities = [UsersDB::class], version = 1)
abstract class DataBaseRepository: RoomDatabase() {

    abstract fun getUsersDao(): UsersDAO
}