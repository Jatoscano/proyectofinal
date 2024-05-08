package com.toscano.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        initListeners()
    }

    private fun initListeners(){

        binding.btnLoginSignIn.setOnClickListener {

            var loginUserCase = LoginUserCase()

            var result = loginUserCase(binding.edtxtLoginUser.text.toString(), binding.edtxtLoginPassword.text.toString())

            //Manejo de Expersiones Lambda
            result.onSuccess {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
            }

            result.onFailure {
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLoginSignUp.setOnClickListener{

            var intentSignUpActivity = Intent(this, SignUpActivity::class.java)
            startActivity(intentSignUpActivity)

        }

        Log.d("UCE", "Metodo onCreate")
    }
}