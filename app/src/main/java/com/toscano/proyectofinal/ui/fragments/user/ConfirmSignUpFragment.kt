package com.toscano.proyectofinal.ui.fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.FragmentConfirmSignUpBinding

class ConfirmSignUpFragment : Fragment() {

    private lateinit var binding: FragmentConfirmSignUpBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmSignUpBinding.bind(inflater.inflate(R.layout.fragment_confirm_sign_up, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }
    private fun initListeners(){
        
        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_confirmSignUpFragment_to_productsFragment)
        }
    }
}