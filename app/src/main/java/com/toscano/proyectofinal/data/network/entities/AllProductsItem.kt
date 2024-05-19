package com.toscano.proyectofinal.data.network.entities

data class AllProductsItem(
    val category: Category?,
    val description: String?,
    val id: Int?,
    val images: List<String?>,
    val price: Int?,
    val title: String?
)