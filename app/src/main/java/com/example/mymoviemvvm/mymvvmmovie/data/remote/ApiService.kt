package com.example.mymvvmmovie.data.remote

import com.example.mymvvmmovie.model.detail.MovieDetailResponse
import com.example.mymvvmmovie.model.movie.Best.BestMovieResponse
import com.example.mymvvmmovie.model.movie.Latest.LatestMovieResponse
import com.example.mymvvmmovie.model.movie.Populer.PopulerMovieResponse
import com.example.mymvvmmovie.model.videos.MovieVideosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    //Populer Filmler
    @GET("movie/popular")
    suspend fun getPopulerMovie(): Response<PopulerMovieResponse>

    //En iyiler(Best)
    @GET("movie/top_rated")
    suspend fun getBestMovie(): Response<BestMovieResponse>

    //En Yeniler(Latest)
    @GET("movie/now_playing")
    suspend fun getLatestMovie(): Response<LatestMovieResponse>

    //Details
    @GET("movie/{movie_id}") //olmassa sadece id olarak dene
    suspend fun getDetails(@Path("movie_id") movieId: Int): Response<MovieDetailResponse>

    //Videos
    @GET("movie/{movie_id}/videos")
    suspend fun getVideos(@Path("movie_id") movieId: Int): Response<MovieVideosResponse>

}