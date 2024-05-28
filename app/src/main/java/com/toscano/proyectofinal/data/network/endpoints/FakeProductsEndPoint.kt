package com.toscano.proyectofinal.data.network.endpoints

import com.toscano.proyectofinal.data.network.entities.fakeproducts.Products
import com.toscano.proyectofinal.data.network.entities.products.AllProducts
import retrofit2.Response
import retrofit2.http.GET

interface FakeProductsEndPoint {

    @GET("products")
    suspend fun getProducts(): Response<AllProducts?>
}