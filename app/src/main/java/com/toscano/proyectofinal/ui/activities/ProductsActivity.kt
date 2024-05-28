package com.toscano.proyectofinal.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.data.network.entities.products.Data
import com.toscano.proyectofinal.databinding.ActivityProductsBinding
import com.toscano.proyectofinal.logic.products.GetAllProductsCase
import com.toscano.proyectofinal.ui.adapters.ProductsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
    }

    private fun initRecycler(products: List<Data>){

        binding.rvProducts.adapter = ProductsAdapter(products)
        binding.rvProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    private fun initData(){

        lifecycleScope.launch(Dispatchers.IO){

            val resultProduct = GetAllProductsCase().invoke()

            withContext(Dispatchers.Main){

                resultProduct.onSuccess{ initRecycler(it!!.toList())}
                resultProduct.onFailure { initRecycler(emptyList())}
            }
        }
    }
}