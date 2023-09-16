package com.example.mymvvmmovie.model.movie.Latest

import com.example.mymoviemvvm.mymvvmmovie.models.movie.latest.LatestResult

data class LatestMovieResponse(
    val dates: Dates,
    val page: Int,
    val results: List<LatestResult>,
    val total_pages: Int,
    val total_results: Int
)