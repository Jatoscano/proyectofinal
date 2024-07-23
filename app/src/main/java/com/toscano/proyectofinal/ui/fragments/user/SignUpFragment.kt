package com.toscano.proyectofinal.ui.fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.data.local.database.entities.UsersDB
import com.toscano.proyectofinal.data.local.repository.DataBaseRepository
import com.toscano.proyectofinal.databinding.FragmentSignUpBinding
import com.toscano.proyectofinal.logic.usercases.SignUpUserCase
import com.toscano.proyectofinal.ui.core.ProyectoFinal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var connection: DataBaseRepository
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.bind(inflater.inflate(R.layout.fragment_sign_up, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables()
        initListeners()
    }

    private fun initVariables(){
        binding.btnSignUp.setOnClickListener {

            val signUpUserCase = SignUpUserCase()
            val result = signUpUserCase(binding.edtxtSignUpName.text.toString(),
                binding.edtxtSignUpLastName.text.toString(),
                binding.edtxtSignUpEmail.text.toString(),
                binding.edtxtSignUpPassword.text.toString(),
                binding.edtxtSignUpPasswordConfirm.text.toString())

            val name = binding.edtxtSignUpName.text.toString()
            val lastName = binding.edtxtSignUpLastName.text.toString()
            val emai = binding.edtxtSignUpEmail.text.toString()
            val password = binding.edtxtSignUpPasswordConfirm.text.toString()

            val userdB = UsersDB(name = name, lastName = lastName, email = emai, password = password)

            result.onSuccess {

                lifecycleScope.launch(Dispatchers.IO){connection.getUsersDao().saveUsers(listOf(userdB))}

                findNavController().navigate(R.id.action_signUpFragment_to_confirmSignUpFragment)
                //Toast.makeText(this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show()
            }

            result.onFailure {
                Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initListeners(){
        connection = ProyectoFinal.getDBConnection()
    }

}