package com.toscano.proyectofinal.data.repository

import com.toscano.proyectofinal.data.UserClass

class ListUsers {

    var listUser = listOf(
        UserClass(1, "admin", "admin"),
        UserClass(2, "juan", "juan"),
        UserClass(3,"andres", "andres")
    )

    fun checkUserAndPassword(user: String, password: String): UserClass?{

        var usReturn: UserClass? = null

        listUser.forEach{ us -> if (us.name == user && us.password == password){ usReturn = us } }

        return usReturn

    }
}