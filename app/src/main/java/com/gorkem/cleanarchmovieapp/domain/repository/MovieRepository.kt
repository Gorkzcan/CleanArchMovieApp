package com.gorkem.cleanarchmovieapp.domain.repository

import com.gorkem.cleanarchmovieapp.data.remote.dto.MovieDetailDto
import com.gorkem.cleanarchmovieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search: String): MoviesDto
    suspend fun getMovieDetail(imbdId: String): MovieDetailDto

}