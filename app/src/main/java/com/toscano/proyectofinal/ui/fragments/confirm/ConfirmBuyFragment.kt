package com.toscano.proyectofinal.ui.fragments.confirm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.FragmentConfirmBuyBinding

class ConfirmBuyFragment : Fragment() {

    private lateinit var binding: FragmentConfirmBuyBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmBuyBinding.bind(inflater.inflate(R.layout.fragment_confirm_buy, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }
    private fun initListeners(){

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_confirmBuyFragment_to_productsFragment)
        }
    }

}