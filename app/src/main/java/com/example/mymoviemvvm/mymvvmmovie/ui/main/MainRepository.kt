package com.example.mymvvmmovie.ui.main

import com.example.mymoviemvvm.mymvvmmovie.models.MyResult
import com.example.mymoviemvvm.mymvvmmovie.models.movie.best.BestResults
import com.example.mymoviemvvm.mymvvmmovie.models.movie.latest.LatestResult
import com.example.mymoviemvvm.mymvvmmovie.models.movie.populer.PopulerResult
import com.example.mymvvmmovie.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    //private val apiService: ApiService by lazy { ApiClient.getApiService() }

    suspend fun getPopulerMovies(): MyResult<List<PopulerResult>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getPopulerMovie()
                if (response.isSuccessful) {
                    val data = response.body()?.results ?: emptyList()
                    MyResult.Success(data)
                } else {
                    MyResult.Error(Exception("Error getting popular movies"))
                }
            } catch (e: Exception) {
                MyResult.Error(e)
            }
        }
    }

    suspend fun getBestMovies(): MyResult<List<BestResults>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getBestMovie()
                if (response.isSuccessful) {
                    val data = response.body()?.results ?: emptyList()
                    MyResult.Success(data)
                } else {
                    MyResult.Error(Exception("Error getting best movies"))
                }
            } catch (e: Exception) {
                MyResult.Error(e)
            }
        }

    }

   suspend fun getLatestMovies(): MyResult<List<LatestResult>> {
       return withContext(Dispatchers.IO){
           try {
               val response=apiService.getLatestMovie()
               if (response.isSuccessful){
                   val data=response.body()?.results?: emptyList()
                   MyResult.Success(data)
               }else{
                   MyResult.Error(Exception("Error getting best movies"))
               }
           }catch (e:Exception){
               MyResult.Error(e)
           }
       }

    }
}


