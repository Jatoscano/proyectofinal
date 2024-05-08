package com.toscano.proyectofinal

class LoginUserCase {

    operator fun invoke(user: String, password: String): Result<Boolean>{

        return if (user == "admin" && password == "admin"){
            Result.success(true)
        }

        else {
            Result.failure(Exception("Error de Usuario o Contraseña"))
        }
    }
}