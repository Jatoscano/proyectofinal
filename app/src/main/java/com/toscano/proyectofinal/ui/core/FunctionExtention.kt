package com.toscano.proyectofinal.ui.core

import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI

class FunctionExtention

fun com.toscano.proyectofinal.data.network.entities.fakestore.Data.toFakeStoreDataUI() = FakeStoreDataUI(this._id, this.title, this.description, this.image, this.price, this.slug, this.category?.name)