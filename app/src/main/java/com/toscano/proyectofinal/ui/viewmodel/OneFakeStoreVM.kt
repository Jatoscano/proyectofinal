package com.toscano.proyectofinal.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toscano.proyectofinal.logic.fakestore.GetOneFakeProductUsesCase
import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OneFakeStoreVM: ViewModel() {

    val oneFakeData = MutableLiveData<FakeStoreDataUI?>()
    val error = MutableLiveData<String>()
    fun iniData(title: String){

        viewModelScope.launch(Dispatchers.IO) {
            val result = GetOneFakeProductUsesCase().invoke(title)
            withContext(Dispatchers.Main) {

                result.collect {res ->
                    res.onSuccess {
                        oneFakeData.postValue(it)
                    }

                    res.onFailure {
                        error.postValue(it.message)
                    }
                }
            }
        }
    }
}