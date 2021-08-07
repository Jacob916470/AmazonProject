package com.jacob.amazonproject.presentation.products.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.network.models.MoviesPopularResponse
import com.jacob.amazonproject.data.utils.Configurations
import com.jacob.amazonproject.domain.useCases.GetMoviesPopularUseCase
import com.jacob.amazonproject.presentation.core.base.BaseViewModel
import com.jacob.amazonproject.presentation.products.model.DataProducts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsViewModel(
    private val getMoviesPopularUseCase: GetMoviesPopularUseCase
): BaseViewModel(){

    var moviesPopularResponseMLD = MutableLiveData<MoviesPopularResponse>()
    var moviesPopularResponse:MoviesPopularResponse? = null

    init {
        getProductWS()
        getMoviesPopular()
    }

    private fun getMoviesPopular() {
        job = CoroutineScope(Dispatchers.IO).launch {
            moviesPopularResponse = getMoviesPopularUseCase.invoke(
                apiKey = Configurations.MOVIE_API_KEY,
                page = 1,
                language = "es-MX"
            ).body()
            withContext(Dispatchers.Main){
                moviesPopularResponse?.let {
                    moviesPopularResponseMLD.postValue(
                        it
                    )
                }
            }
        }
    }

    private fun getProductWS() {

    }
}