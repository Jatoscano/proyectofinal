package com.toscano.proyectofinal.data.network.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {

    fun returnStoreRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.storerestapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}