package com.toscano.proyectofinal.data.network.repository

import okhttp3.OkHttpClient
import okhttp3.Request

class AmazonClient {

    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://amazon-products-api2.p.rapidapi.com/products/B09G9FPHY6/offers?api_key=0a3012b27f2972261ed46dd4793a5461")
        .get()
        .addHeader("x-rapidapi-key", "Sign Up for Key")
        .addHeader("x-rapidapi-host", "amazon-products-api2.p.rapidapi.com")
        .build()

    val response = client.newCall(request).execute()
}