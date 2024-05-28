package com.toscano.proyectofinal.data.network.endpoints

import com.toscano.proyectofinal.data.network.entities.products.AllProducts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsEndPoint {

    @GET("products")
    suspend fun getAllProducts(): Response<AllProducts?>
}