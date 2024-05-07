package com.toscano.proyectofinal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var edtxtName = findViewById<EditText>(R.id.edtxt_sign_up_name)
        var edtxtLastName = findViewById<EditText>(R.id.edtxt_sign_up_last_name)
        var edtxtEmail = findViewById<EditText>(R.id.edtxt_sign_up_email)
        var edtxtPassword = findViewById<EditText>(R.id.edtxt_sign_up_password)
        var btnLogin = findViewById<Button>(R.id.btn_sign_up)

        btnLogin.setOnClickListener {
            if (edtxtName.text.toString() == "" &&
                edtxtLastName.text.toString() == "" &&
                edtxtEmail.text.toString() == "" &&
                edtxtPassword.text.toString() == ""){
                Snackbar.make(edtxtName, "Hay un error en el usuario",Snackbar.LENGTH_SHORT).show()
            }

            else{
                Snackbar.make(edtxtPassword, "Usuario ingresado correctamente", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}