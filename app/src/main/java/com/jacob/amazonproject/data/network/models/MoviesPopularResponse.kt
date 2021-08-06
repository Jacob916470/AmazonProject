package com.jacob.amazonproject.data.network.models

import com.google.gson.annotations.SerializedName

data class MoviesPopularResponse(
    val page: Int,
    val results: List<Result>,
    @SerializedName(value = "total_pages")
    val totalPages: Int,
    @SerializedName(value = "total_results")
    val totalResults: Int
)