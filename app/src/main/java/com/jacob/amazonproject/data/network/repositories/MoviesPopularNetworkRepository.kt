package com.jacob.amazonproject.data.network.repositories

import com.jacob.amazonproject.data.network.NetworkModule
import com.jacob.amazonproject.data.network.models.MoviesPopularResponse
import com.jacob.amazonproject.data.network.services.MoviePopularService
import com.jacob.amazonproject.data.utils.Configurations
import com.jacob.amazonproject.domain.repositories.GetMoviesPopularRepository
import retrofit2.Response

class MoviesPopularNetworkRepository():GetMoviesPopularRepository {

    private val retofitInstance =
        NetworkModule().provideRetrofit(baseURL = Configurations().getBaseURL())

    override suspend fun getMoviesPopularRepository(
        apiKey: String,
        page: Int,
        language: String
    ): Response<MoviesPopularResponse> {
        return NetworkModule().provideApi(
            retrofit = retofitInstance,
            service = MoviePopularService::class.java
        ).getMoviesPopular(
            apiKey = apiKey,
            page = page,
            language = language
        )
    }
}