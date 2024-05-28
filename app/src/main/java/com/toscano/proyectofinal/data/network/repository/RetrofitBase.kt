package com.toscano.proyectofinal.data.network.repository

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {

    const val STORE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsImlhdCI6MTY3Mjc2NjAyOCwiZXhwIjoxNjc0NDk0MDI4fQ.kCak9sLJr74frSRVQp0_27BY4iBCgQSmoT3vQVWKzJg"

    const val AMAZON_API_KEY = "0a3012b27f2972261ed46dd4793a5461"
    fun returnBaseRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClient())
            .build()
    }

    fun returnBaseRetrofit1(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClient())
            .build()
    }

    fun returnAmazonRetrofit(): Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://amazon-products-api2.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(amazonApiClient())
            .build()
    }

    private fun apiClient(): OkHttpClient = OkHttpClient.Builder().addInterceptor(StoreInterceptor(RetrofitBase.STORE_API_KEY)).build()

    private fun amazonApiClient(): OkHttpClient = OkHttpClient.Builder().addInterceptor(StoreInterceptor(RetrofitBase.AMAZON_API_KEY)).build()
}