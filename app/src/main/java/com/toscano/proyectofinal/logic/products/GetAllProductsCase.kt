package com.toscano.proyectofinal.logic.products

import android.util.Log
import com.toscano.proyectofinal.data.network.endpoints.FakeProductsEndPoint
import com.toscano.proyectofinal.data.network.endpoints.ProductsEndPoint
import com.toscano.proyectofinal.data.network.entities.products.AllProducts
import com.toscano.proyectofinal.data.network.entities.products.Data
import com.toscano.proyectofinal.data.network.repository.RetrofitBase

class GetAllProductsCase {

    suspend operator fun invoke(): Result<List<Data>?> {

            val response = RetrofitBase.returnBaseRetrofit1()
                .create(ProductsEndPoint::class.java)
                .getAllProducts()

            return if (response.isSuccessful){

                val product = response.body()?.data
                Log.d("RSP", product.toString())
                Result.success(product)
            }
            else{
                Log.d("RSP", "La ejecucion fallo")
                Result.failure(Exception("Error"))
            }
    }

}