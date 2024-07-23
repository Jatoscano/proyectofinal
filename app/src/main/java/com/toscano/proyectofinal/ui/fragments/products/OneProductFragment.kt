package com.toscano.proyectofinal.ui.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.snackbar.Snackbar
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.FragmentOneProductBinding
import com.toscano.proyectofinal.ui.viewmodel.OneFakeStoreVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OneProductFragment : Fragment() {

    private lateinit var binding: FragmentOneProductBinding
    private val oneFakeStoreVM: OneFakeStoreVM by viewModels()
    private val args: OneProductFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentOneProductBinding.bind(inflater.inflate(R.layout.fragment_one_product, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initObservers()
        initListeners()

    }

    private fun initListeners(){
        binding.btnPay.setOnClickListener {
            findNavController().navigate(R.id.action_oneProductFragment_to_loadingFragment)
        }
    }

    private fun getData(){

        lifecycleScope.launch(Dispatchers.Main) {

            oneFakeStoreVM.iniData(args.idProduct)

        }
    }

    private fun initObservers(){

        oneFakeStoreVM.oneFakeData.observe(viewLifecycleOwner){
            product ->
            if (product != null){

                binding.txtOneName.text = product.title.toString()
                binding.txtOneDescription.text = product.description.toString()
                binding.txtOnePrice.text = product.price.toString()
                binding.txtOneCategory.text = product.slug.toString()
                binding.txtSlug.text = product.slug.toString()
                binding.imgOne.load(product.image)
        }

        }

        oneFakeStoreVM.error.observe(viewLifecycleOwner){
            Snackbar.make(binding.txtOneName, it, Snackbar.LENGTH_LONG).show()
        }
    }

}