package com.toscano.proyectofinal.ui.fragments.confirm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.FragmentLoadingBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingFragment : Fragment() {

    private lateinit var binding: FragmentLoadingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoadingBinding.bind(inflater.inflate(R.layout.fragment_loading, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners(){

        binding.animationViewProduct.visibility = View.VISIBLE


        lifecycleScope.launch(Dispatchers.Main) {

            delay(4000)
            findNavController().navigate(R.id.action_loadingFragment_to_confirmBuyFragment)
            binding.animationViewProduct.visibility = View.INVISIBLE
        }
    }
}