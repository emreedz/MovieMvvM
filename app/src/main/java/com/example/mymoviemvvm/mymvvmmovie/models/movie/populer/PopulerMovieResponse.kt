package com.example.mymvvmmovie.model.movie.Populer

import com.example.mymoviemvvm.mymvvmmovie.models.movie.populer.PopulerResult

data class PopulerMovieResponse(
    val page: Int,
    val results: List<PopulerResult>,
    val total_pages: Int,
    val total_results: Int
)