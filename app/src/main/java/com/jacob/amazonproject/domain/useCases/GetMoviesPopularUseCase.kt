package com.jacob.amazonproject.domain.useCases

import com.jacob.amazonproject.data.network.models.MoviesPopularResponse
import com.jacob.amazonproject.domain.repositories.GetMoviesPopularRepository
import retrofit2.Response

class GetMoviesPopularUseCase(
    private val getMoviesPopularRepository: GetMoviesPopularRepository
) {
    suspend fun invoke(
        apiKey: String,
        page: Int,
        language: String
    ): Response<MoviesPopularResponse> {
        return getMoviesPopularRepository.getMoviesPopularRepository(
            apiKey = apiKey,
            page = page,
            language = language
        )
    }
}