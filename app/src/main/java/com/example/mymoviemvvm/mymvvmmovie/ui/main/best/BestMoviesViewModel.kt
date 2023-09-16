package com.example.mymoviemvvm.mymvvmmovie.ui.main.best

import androidx.lifecycle.ViewModel
import com.example.mymoviemvvm.mymvvmmovie.models.MyResult
import com.example.mymoviemvvm.mymvvmmovie.models.movie.best.BestResults
import com.example.mymvvmmovie.ui.main.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BestMoviesViewModel @Inject constructor(private val repository: MainRepository)  : ViewModel() {
    //private val repository: MainRepository by lazy { MainRepository() }

   suspend fun getBestMovies(): MyResult<List<BestResults>> = repository.getBestMovies()
}