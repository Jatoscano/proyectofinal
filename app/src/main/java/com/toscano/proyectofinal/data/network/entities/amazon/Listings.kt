package com.toscano.proyectofinal.data.network.entities.amazon

data class Listings(
    val fullfilled_by_amazon: Boolean,
    val has_prime_shipping: Boolean,
    val price: Any,
    val price_with_currency: String,
    val shipping_price: Any,
    val ships_from: String,
    val sold_by: String
)