package com.toscano.proyectofinal.data.network.entities.amazon

data class Item(
    val author: String,
    val average_rating: Double,
    val brand: String,
    val image: String,
    val listings_link: String,
    val name: String,
    val product_information: ProductInformation,
    val subtitle: String,
    val total_reviews: Int
)