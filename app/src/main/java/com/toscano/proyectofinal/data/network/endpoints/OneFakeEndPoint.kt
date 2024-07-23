package com.toscano.proyectofinal.data.network.endpoints

import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OneFakeEndPoint {


    @GET("products/{title}")
    suspend fun getOneFakeProduct(@Path("title") title: String): Response<FakeStoreDataUI>
}