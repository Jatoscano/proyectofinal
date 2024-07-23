package com.toscano.proyectofinal.data.network.endpoints

import com.toscano.proyectofinal.data.network.entities.fakestore.FakeProducts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FakeEndPoint {

    @GET("products")
    suspend fun getFakeProducts(@Query("limit") limit: Int): Response<FakeProducts?>
}