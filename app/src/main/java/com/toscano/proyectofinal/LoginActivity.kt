package com.toscano.proyectofinal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var edtxtUser = findViewById<EditText>(R.id.edtxt_login_user)
        var edtxtPassword = findViewById<EditText>(R.id.edtxt_login_password)
        var btnLogin = findViewById<Button>(R.id.btn_login_sign_in)
        var btnSignUp = findViewById<Button>(R.id.btn_login_sign_up)

        btnLogin.setOnClickListener {
            if (edtxtUser.text.toString() == "admin" && edtxtPassword.text.toString() == "admin"){
                Snackbar.make(edtxtUser, "Bienvenido", Snackbar.LENGTH_SHORT).show()
            }

            else{
                Snackbar.make(edtxtUser, "Hay un error en el usuario", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}