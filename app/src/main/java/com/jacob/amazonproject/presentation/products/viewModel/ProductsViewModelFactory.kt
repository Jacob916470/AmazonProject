package com.jacob.amazonproject.presentation.products.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.amazonproject.domain.useCases.GetMoviesPopularUseCase

class ProductsViewModelFactory(
 private val getMoviesPopularUseCase: GetMoviesPopularUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(
            getMoviesPopularUseCase
        )as T
    }
}