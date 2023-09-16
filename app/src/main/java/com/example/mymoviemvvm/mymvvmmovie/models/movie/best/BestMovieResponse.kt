package com.example.mymvvmmovie.model.movie.Best

import com.example.mymoviemvvm.mymvvmmovie.models.movie.best.BestResults

data class BestMovieResponse(
    val page: Int,
    val results: List<BestResults>,
    val total_pages: Int,
    val total_results: Int
)