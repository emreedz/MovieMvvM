package com.example.mymoviemvvm.mymvvmmovie.ui.main.latest

import androidx.lifecycle.ViewModel
import com.example.mymoviemvvm.mymvvmmovie.models.MyResult
import com.example.mymoviemvvm.mymvvmmovie.models.movie.latest.LatestResult
import com.example.mymvvmmovie.ui.main.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LatestMoviesViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    //private val repository: MainRepository by lazy { MainRepository() }

    suspend fun getLatestMovies(): MyResult<List<LatestResult>> = repository.getLatestMovies()
}