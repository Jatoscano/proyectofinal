package com.toscano.proyectofinal.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.ActivityMainBinding
import com.toscano.proyectofinal.logic.products.GetAllProductsCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCorrutine()
    }

    private fun initCorrutine() {

        binding.btnMain.setOnClickListener {

            lifecycleScope.launch(Dispatchers.IO) { GetAllProductsCase().invoke() }
        }
    }
}