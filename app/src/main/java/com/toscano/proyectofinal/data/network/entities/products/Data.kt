package com.toscano.proyectofinal.data.network.entities.products

data class Data(
    val category: Category?,
    val creationAt: String?,
    val description: String?,
    val id: Int?,
    val images: List<String>?,
    val price: Int?,
    val title: String?,
    val updatedAt: String?
)