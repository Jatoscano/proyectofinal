package com.toscano.proyectofinal.logic.usercases

import com.toscano.proyectofinal.data.local.UserClass
import com.toscano.proyectofinal.data.local.repository.ListUsers

class LoginUserCase (var listUsers: ListUsers){

    operator fun invoke(user: String, password: String): Result<UserClass>{

        var check = listUsers.checkUserAndPassword(user, password)

        return if (check != null){ Result.success(check) }

        else { Result.failure(Exception("Error de Usuario o Contraseña")) }

    }
}