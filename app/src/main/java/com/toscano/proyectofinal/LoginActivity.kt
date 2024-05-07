package com.toscano.proyectofinal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.toscano.proyectofinal.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginSignIn.setOnClickListener {
            if (binding.edtxtLoginUser.text.toString() == "admin" && binding.edtxtLoginPassword.text.toString() == "admin"){
                Snackbar.make(binding.edtxtLoginPassword, "Bienvenido", Snackbar.LENGTH_SHORT).show()
            }

            else{
                Snackbar.make(binding.edtxtLoginPassword, "Hay un error en el usuario", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnLoginSignUp.setOnClickListener {
            Snackbar.make(binding.edtxtLoginUser, "Estamos en proceso", Snackbar.LENGTH_SHORT).show()
        }
    }
}