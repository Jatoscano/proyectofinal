package com.toscano.proyectofinal.data.network.entities.amazon

data class AmazonProducts(
    val item: Item,
    val listings: List<Listings>,
    val pagination: List<Any>
)