package com.toscano.proyectofinal

class SignUpUserCase {

    operator fun invoke(name: String,lastName: String, email: String, password: String, passwordConfirm: String): Result<Boolean>{

        return if (name == "" && lastName == "" && email == "" && password == "" && passwordConfirm == ""){
            Result.failure(Exception("Error de Usuario o Contraseña"))
        }

        else {
            Result.success(true)
        }
    }
}