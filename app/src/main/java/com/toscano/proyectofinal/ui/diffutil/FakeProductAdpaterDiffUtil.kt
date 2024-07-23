package com.toscano.proyectofinal.ui.diffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.ItemProductsBinding
import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI

class FakeProductAdpaterDiffUtil(private val onClickAction: (FakeStoreDataUI) -> Unit): ListAdapter<FakeStoreDataUI ,FakeProductAdpaterDiffUtil.FakeViewHolder>(DiffUtilFakeStoreCallBack) {

    //Clase que le da forma al RecyclerView
    //Hacemos una inyeccion de dependencias por medio de constructores
    var fakeProduct: List<FakeStoreDataUI> = emptyList()
    class FakeViewHolder(view: View) : RecyclerView.ViewHolder(view){

        //Enviamos una vista
        private val binding = ItemProductsBinding.bind(view)

        fun render(data: FakeStoreDataUI, onClickAction:(FakeStoreDataUI) -> Unit){

            //Glide.with(binding.root).load(data.image).into(binding.imgProduct)
            binding.imgProduct.load(data.image){ placeholder(R.drawable.katana) }
            binding.txtTitle.text = data.title
            binding.txtPrice.text = data.price.toString()
            binding.txtDescription.text = data.description

            itemView.setOnClickListener { onClickAction(data) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return FakeViewHolder(inflater.inflate(R.layout.item_products, parent,false))
    }

    override fun getItemCount() = fakeProduct.size


    override fun onBindViewHolder(holder: FakeViewHolder, position: Int) {

        holder.render(fakeProduct[position], onClickAction)
    }

    private object DiffUtilFakeStoreCallBack: DiffUtil.ItemCallback<FakeStoreDataUI>(){
        override fun areItemsTheSame(oldItem: FakeStoreDataUI, newItem: FakeStoreDataUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FakeStoreDataUI, newItem: FakeStoreDataUI): Boolean {
            return oldItem == newItem
        }

    }
}