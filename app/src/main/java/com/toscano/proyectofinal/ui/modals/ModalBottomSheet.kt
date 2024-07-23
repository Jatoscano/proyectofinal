package com.toscano.proyectofinal.ui.modals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.toscano.proyectofinal.R
import com.toscano.proyectofinal.databinding.ModalBottomSheetBinding
import com.toscano.proyectofinal.logic.fakestore.GetOneFakeProductUsesCase
import com.toscano.proyectofinal.ui.entities.FakeStoreDataUI
import com.toscano.proyectofinal.ui.fragments.products.ProductsFragmentDirections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ModalBottomSheet(val product: FakeStoreDataUI?): BottomSheetDialogFragment() {


    private lateinit var binding: ModalBottomSheetBinding
    private val oneFakeData = MutableLiveData<FakeStoreDataUI>()
    private val error = MutableLiveData<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{

        val viewRoot = inflater.inflate(R.layout.modal_bottom_sheet, container, false)
        binding = ModalBottomSheetBinding.bind(viewRoot)
        BottomSheetBehavior.from(binding.standardBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            peekHeight = 0
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch(Dispatchers.Main) {
            binding.animationView.visibility = View.VISIBLE
            val item = withContext(Dispatchers.IO) {
                product?.title?.let { loadData(it) }
            }
            delay(5000)
            binding.imgProd.load(product?.image)
            binding.txtProduct.text = product?.title.toString()
            binding.txtDescription.text = product?.description.toString()
            binding.txtCategory.text = product?.slug.toString()
            binding.txtPrice.text = product?.price.toString()
            binding.bottomsheetButton.setOnClickListener {

                /*
                var intent = Intent(requireContext(), OneProductFragment::class.java).apply {
                    putExtra("title", product?.title.toString())
                }
                startActivity(intent)
                 */

                findNavController().navigate(ProductsFragmentDirections.actionProductsFragmentToOneProductFragment(idProduct = product?.title.toString()))
            }
            binding.animationView.visibility = View.INVISIBLE
        }

    }

    fun loadData(itemId: String) {

        lifecycleScope.launch(Dispatchers.IO) {
            val result = GetOneFakeProductUsesCase().invoke(itemId)
            withContext(Dispatchers.Main) {

                result.collect {res ->
                    res.onSuccess {
                        oneFakeData.postValue(it)
                    }

                    res.onFailure {
                        error.postValue(it.message)
                    }
                }
            }
        }
    }
}