package com.jacob.amazonproject.presentation.products.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.network.repositories.MoviesPopularNetworkRepository
import com.jacob.amazonproject.databinding.FragmentProductsBinding
import com.jacob.amazonproject.domain.useCases.GetMoviesPopularUseCase
import com.jacob.amazonproject.presentation.core.callBack.OnItemClickListener
import com.jacob.amazonproject.presentation.products.adapters.ProductsAdapter
import com.jacob.amazonproject.presentation.products.model.DataProducts
import com.jacob.amazonproject.presentation.products.viewModel.ProductsViewModel
import com.jacob.amazonproject.presentation.products.viewModel.ProductsViewModelFactory

class FragmentProducts: Fragment(), OnItemClickListener<DataProducts> {

    private var fragmentProductsBinding: FragmentProductsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_products,
            container,
            false
        )

        fragmentProductsBinding?.productsViewModel =
            ViewModelProvider(
                this,
                ProductsViewModelFactory(
                    GetMoviesPopularUseCase(MoviesPopularNetworkRepository())
                )
            ).get(ProductsViewModel::class.java)

        return fragmentProductsBinding?.root
    }

    /** viewLifecycleOwner = es el owner del observer*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentProductsBinding?.productsViewModel?.productL?.observe(
            viewLifecycleOwner,{products ->
                if (products.isNotEmpty()){
                    fragmentProductsBinding?.rvProducts?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = ProductsAdapter(products,this@FragmentProducts)
                    }
                }
            }
        )
    }

    override fun onItemClick(item: DataProducts, type: String?) {
        val bundle = bundleOf("image" to item.img)
      // findNavController().navigate(R.id.action_productsFragment_to_fragmentProductDetails,bundle)
    }
}