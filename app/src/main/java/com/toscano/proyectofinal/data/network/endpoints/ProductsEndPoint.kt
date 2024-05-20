package com.toscano.proyectofinal.data.network.endpoints

import com.toscano.proyectofinal.data.network.entities.AllProducts
import retrofit2.Response
import retrofit2.http.GET

interface ProductsEndPoint {

    @GET("products")
    suspend fun getAllProducts(): Response<List<AllProducts?>>
}