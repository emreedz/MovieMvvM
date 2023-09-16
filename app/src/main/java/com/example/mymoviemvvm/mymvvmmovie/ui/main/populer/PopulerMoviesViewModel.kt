package com.example.mymvvmmovie.ui.main.populer

import androidx.lifecycle.ViewModel
import com.example.mymoviemvvm.mymvvmmovie.models.MyResult
import com.example.mymoviemvvm.mymvvmmovie.models.movie.populer.PopulerResult
import com.example.mymvvmmovie.ui.main.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopulerMoviesViewModel @Inject constructor(private val repository: MainRepository): ViewModel() {

    suspend fun getPopulerMovies(): MyResult<List<PopulerResult>> =repository.getPopulerMovies()
}

