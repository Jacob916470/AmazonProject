package com.jacob.amazonproject.presentation.products.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jacob.amazonproject.R
import com.jacob.amazonproject.databinding.FragmentProductDetailsBinding
import com.jacob.amazonproject.presentation.products.viewModel.ProductsViewModel

class FragmentProductDetails: Fragment() {
    /**
     * Cuando inicie sesión tenga un 10% de descuento
     * Hay alguna otra manera de pasar datos entre fragments
     * var imagen : Int = 0, Explicar nuevamente
     * */
    private var fragmentProductDetailsBinding: FragmentProductDetailsBinding? = null
    var imagen : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imagen = it.getInt("image")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_product_details,
            container,
            false
        )
        fragmentProductDetailsBinding?.imageDetails?.setImageResource(imagen)

        fragmentProductDetailsBinding?.productDetailsViewModel =
            ViewModelProvider(
                this
            ).get(ProductsViewModel::class.java)

        return fragmentProductDetailsBinding?.root
    }
}