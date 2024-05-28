package com.toscano.proyectofinal.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.data.network.entities.products.Data
import com.toscano.proyectofinal.databinding.ItemProductsBinding

class ProductsAdapter(private val listProducts: List<Data>): RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ItemProductsBinding.bind(view)
        fun render(data: Data){

            Glide.with(binding.root).load(data.images).into(binding.imgProduct)
            binding.txtTitle.text = data.title.toString()
            binding.txtPrice.text = data.price.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {

        val inlfater =LayoutInflater.from(parent.context)

        return ProductsViewHolder(inlfater.inflate(R.layout.item_products,parent,false))
    }

    override fun getItemCount() = listProducts.size
    override fun onBindViewHolder(holder: ProductsAdapter.ProductsViewHolder, position: Int) {

        holder.render(listProducts[position])
    }
}