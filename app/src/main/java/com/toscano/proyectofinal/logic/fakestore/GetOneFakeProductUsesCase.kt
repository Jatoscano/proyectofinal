package com.toscano.proyectofinal.logic.fakestore

import android.util.Log
import com.toscano.proyectofinal.data.network.endpoints.OneFakeEndPoint
import com.toscano.proyectofinal.data.network.repository.RetrofitBase
import kotlinx.coroutines.flow.flow

class GetOneFakeProductUsesCase {

    operator fun invoke(title: String)= flow {

        val response = RetrofitBase.returnStoreRetrofit()
            .create(OneFakeEndPoint::class.java)
            .getOneFakeProduct(title)

        if (response.isSuccessful){

            val data = response.body()
            Log.d("RSP", data.toString())
            emit(Result.success(data))
        }

        else {
            Log.d("RSP", "La ejecucion fallo")
            emit(Result.failure(Exception("")))
        }
    }
}