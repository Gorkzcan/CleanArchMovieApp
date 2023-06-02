package com.gorkem.cleanarchmovieapp.data.remote.dto

import com.gorkem.cleanarchmovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET(".")//base urlde end point olmadığı için . koyuyoruz end point -> movies vs. olursa oluyor
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MovieDetailDto
}