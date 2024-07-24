package com.toscano.proyectofinal.logic.fakestore

import android.util.Log
import com.toscano.proyectofinal.data.network.endpoints.FakeEndPoint
import com.toscano.proyectofinal.data.network.repository.RetrofitBase
import com.toscano.proyectofinal.ui.core.toFakeStoreDataUI
import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI
import kotlinx.coroutines.flow.flow

class GetFakeProductUsesCase {

    operator fun invoke() = flow{

        val item = mutableListOf<FakeStoreDataUI>()
        val response = RetrofitBase.returnStoreRetrofit()
            .create(FakeEndPoint::class.java)
            .getFakeProducts(10)

        if (response.isSuccessful){

            response.body()?.data?.forEach { item.add(it.toFakeStoreDataUI()) }
            Log.d("RSP", item.toString())
            emit(Result.success(item.toList()))
        }

        else {
            Log.d("RSP", "La ejecucion fallo")
            emit(Result.failure(Exception("")))
        }
    }
}