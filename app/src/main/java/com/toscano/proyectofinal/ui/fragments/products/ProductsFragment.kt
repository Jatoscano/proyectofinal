package com.toscano.proyectofinal.ui.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.FragmentProductsBinding
import com.toscano.proyectofinal.ui.diffutil.FakeProductAdpaterDiffUtil
import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI
import com.toscano.proyectofinal.ui.modals.ModalBottomSheet
import com.toscano.proyectofinal.ui.viewmodel.FakeStoreVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private val fakeProductsVM: FakeStoreVM by viewModels()
    private var fakeItems: MutableList<FakeStoreDataUI> = mutableListOf()
    private lateinit var fakeProductAdpaterDiffUtil: FakeProductAdpaterDiffUtil

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductsBinding.bind(inflater.inflate(R.layout.fragment_products, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVariables()
        initListeners()
        initData()
        initObservers()

    }

    private fun initListeners(){
        binding.rfSwipe.setOnRefreshListener {

            initData()
            binding.rfSwipe.isRefreshing = false

        }
    }

    private fun initVariables(){
        //Fake Store

        fakeProductAdpaterDiffUtil = FakeProductAdpaterDiffUtil{ descriptionItem(it) }
        binding.rvProducts.adapter = fakeProductAdpaterDiffUtil
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

    }

    private fun initData(){

        binding.animationViewProduct.visibility = View.VISIBLE


        lifecycleScope.launch(Dispatchers.Main) {

            delay(4000)
            fakeProductsVM.iniData()
            binding.animationViewProduct.visibility = View.INVISIBLE
        }


    }

    private fun initObservers(){

        fakeProductsVM.listFakeData.observe(viewLifecycleOwner){
            fakeItems = it.toMutableList()
            fakeProductAdpaterDiffUtil.fakeProduct = fakeItems
            fakeProductAdpaterDiffUtil.notifyDataSetChanged()
        }

        fakeProductsVM.error.observe(viewLifecycleOwner){
            Snackbar.make(binding.rvProducts, it, Snackbar.LENGTH_LONG).show()
        }


    }
    
    private fun descriptionItem(product: FakeStoreDataUI){

        val modal = ModalBottomSheet(product)
        modal.show(requireActivity().supportFragmentManager, "TAG")


    }

}
