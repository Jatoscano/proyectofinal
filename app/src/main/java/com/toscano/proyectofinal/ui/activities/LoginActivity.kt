package com.toscano.proyectofinal.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.toscano.proyectofinal.data.local.repository.ListUsers
import com.toscano.proyectofinal.logic.usercases.LoginUserCase
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

            var loginUserCase = LoginUserCase(ListUsers())

            var result = loginUserCase(binding.edtxtLoginUser.text.toString(), binding.edtxtLoginPassword.text.toString())

            result.onSuccess {

                user -> var intentMainActivity = Intent(this, MainActivity::class.java).apply { putExtra("IdUser", user.id) }
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                startActivity(intentMainActivity)
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