package com.jacob.amazonproject.domain.repositories

import com.jacob.amazonproject.data.network.models.MoviesPopularResponse
import retrofit2.Response

interface GetMoviesPopularRepository {

    suspend fun getMoviesPopularRepository(
        apiKey: String,
        page: Int,
        language: String
    ):Response<MoviesPopularResponse>
}