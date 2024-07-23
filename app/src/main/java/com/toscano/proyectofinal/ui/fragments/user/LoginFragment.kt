package com.toscano.proyectofinal.ui.fragments.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.data.local.repository.DataBaseRepository
import com.toscano.proyectofinal.data.local.repository.ListUsers
import com.toscano.proyectofinal.databinding.FragmentLoginBinding
import com.toscano.proyectofinal.logic.usercases.LoginUserCase
import com.toscano.proyectofinal.ui.core.ProyectoFinal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var connection: DataBaseRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.bind(inflater.inflate(R.layout.fragment_login, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables()
        initListeners()
    }

    private fun initVariables(){
        binding.btnLoginSignIn.setOnClickListener {

            var loginUserCase = LoginUserCase(ListUsers())

            var result = loginUserCase(binding.edtxtLoginUser.text.toString(), binding.edtxtLoginPassword.text.toString())

            result.onSuccess {

                lifecycleScope.launch(Dispatchers.IO){connection.getUsersDao().getOneUser(binding.edtxtLoginUser.text.toString())}
                Toast.makeText(requireContext(), "Bienvenido", Toast.LENGTH_SHORT).show()
                //user -> var intentMainActivity = Intent(requireActivity(), ProductsActivity::class.java).apply { putExtra("IdUser", user.id) }
                //startActivity(intentMainActivity)
                findNavController().navigate(R.id.action_loginFragment_to_productsFragment)
            }

            result.onFailure {
                Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLoginSignUp.setOnClickListener{

            //val intentSignUpActivity = Intent(requireActivity(), SignUpActivity::class.java)
            //startActivity(intentSignUpActivity)
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)

        }

        Log.d("UCE", "Metodo onCreate")
    }

    private fun initListeners(){
        connection = ProyectoFinal.getDBConnection()
    }

}