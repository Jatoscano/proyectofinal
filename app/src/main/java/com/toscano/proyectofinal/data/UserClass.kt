package com.toscano.proyectofinal.data

import android.util.Log

data class UserClass(var id: Int, var name: String, var password: String){
    init { Log.d("TAG", "Se inicia la instancia") }

}
