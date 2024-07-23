package com.toscano.proyectofinal.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.toscano.proyectofinal.data.local.database.entities.UsersDB

@Dao
interface UsersDAO {

    @Query("select * from users")
    fun getAllUsers(): List<UsersDB>

    @Query("select * from users where name_user = :name")
    fun getOneUser(name: String): UsersDB

    @Insert
    fun saveUsers(user: List<UsersDB>)
}