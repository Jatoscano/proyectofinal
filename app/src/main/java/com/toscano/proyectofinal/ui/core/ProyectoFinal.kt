package com.toscano.proyectofinal.ui.core

import android.app.Application
import androidx.room.Room
import com.toscano.proyectofinal.data.local.repository.DataBaseRepository

class ProyectoFinal: Application() {

    override fun onCreate() {
        super.onCreate()

        dbConnection = Room.databaseBuilder(applicationContext, DataBaseRepository::class.java, "Datos").build()

    }

    companion object{

        private var dbConnection: DataBaseRepository? = null

        fun getDBConnection(): DataBaseRepository{

            return dbConnection!!
        }
    }
}