package com.toscano.proyectofinal.data.network.repository

import okhttp3.Interceptor
import okhttp3.Response

class StoreInterceptor(private val apiKey: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val storeUrl  = chain.request().url.newBuilder().addQueryParameter("api_token", apiKey).build()

        val storeRequest = chain.request().newBuilder().url(storeUrl).build()

        return chain.proceed(storeRequest)
    }


}