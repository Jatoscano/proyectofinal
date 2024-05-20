package com.toscano.proyectofinal.logic.products

import android.util.Log
import com.toscano.proyectofinal.data.network.endpoints.ProductsEndPoint
import com.toscano.proyectofinal.data.network.repository.RetrofitBase

class GetAllProductsCase {

    suspend operator fun invoke(){

        val call = RetrofitBase.returnBaseRetrofit()
        val service  = call.create(ProductsEndPoint::class.java)
        val response = service.getAllProducts()

        if (response.isSuccessful){

            val body = response.body()
            Log.d("RSP", body.toString())
        }
        else{
            Log.d("RSP", "La ejecucion fallo")
        }
    }
}