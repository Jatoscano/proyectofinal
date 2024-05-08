package com.toscano.proyectofinal

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.toscano.proyectofinal.databinding.ActivityConfirmSignUpBinding

class ConfirmSignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityConfirmSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners(){

        binding.btnContinue.setOnClickListener {
            Toast.makeText(this, "Estamos en proceso", Toast.LENGTH_SHORT).show()
        }
    }
}