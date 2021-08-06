package com.jacob.amazonproject.data.network.services

import com.jacob.amazonproject.data.network.models.MoviesPopularResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviePopularService {

    /** End point */
    @GET(value = "movie/popular")
    suspend fun getMoviesPopular(
        @Query(value = "api_key")
        apiKey: String,
        @Query(value = "page")
        page: Int,
        @Query(value = "language")
        language: String
    ): Response<MoviesPopularResponse>

}