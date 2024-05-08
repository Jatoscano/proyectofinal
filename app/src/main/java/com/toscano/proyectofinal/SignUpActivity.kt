package com.toscano.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.toscano.proyectofinal.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners(){

        binding.btnSignUp.setOnClickListener {

            var signUpUserCase = SignUpUserCase()
            var result = signUpUserCase(binding.edtxtSignUpName.text.toString(),
                                        binding.edtxtSignUpLastName.text.toString(),
                                        binding.edtxtSignUpEmail.text.toString(),
                                        binding.edtxtSignUpPassword.text.toString(),
                                        binding.edtxtSignUpPasswordConfirm.text.toString())

            result.onSuccess {

                var intnetConfirmSignUpActivity = Intent(this, ConfirmSignUpActivity::class.java)
                startActivity(intnetConfirmSignUpActivity)
                //Toast.makeText(this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show()
            }

            result.onFailure {
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}