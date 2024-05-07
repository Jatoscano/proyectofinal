package com.toscano.proyectofinal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        binding.btnSignUp.setOnClickListener {
            if (binding.edtxtSignUpName.text.toString() == "" &&
                binding.edtxtSignUpLastName.text.toString() == "" &&
                binding.edtxtSignUpEmail.text.toString() == "" &&
                binding.edtxtSignUpPassword.text.toString() == ""){
                Snackbar.make(binding.edtxtSignUpPassword, "Hay un error en el usuario",Snackbar.LENGTH_SHORT).show()
            }

            else{
                Snackbar.make(binding.edtxtSignUpPassword, "Usuario ingresado correctamente", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}