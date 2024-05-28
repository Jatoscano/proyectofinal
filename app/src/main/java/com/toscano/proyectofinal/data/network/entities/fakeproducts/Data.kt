package com.toscano.proyectofinal.data.network.entities.fakeproducts

data class Data(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)