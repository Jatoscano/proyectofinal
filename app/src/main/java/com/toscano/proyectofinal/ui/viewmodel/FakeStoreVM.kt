package com.toscano.proyectofinal.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toscano.proyectofinal.logic.fakestore.GetFakeProductUsesCase
import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FakeStoreVM: ViewModel() {

    val listFakeData = MutableLiveData<List<FakeStoreDataUI>>()
    val error = MutableLiveData<String>()
    fun iniData(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = GetFakeProductUsesCase().invoke()
            withContext(Dispatchers.Main) {

                result.collect {res ->
                    res.onSuccess {
                        listFakeData.postValue(it)
                    }

                    res.onFailure {
                        error.postValue(it.message)
                    }
                }
            }
        }
    }

}