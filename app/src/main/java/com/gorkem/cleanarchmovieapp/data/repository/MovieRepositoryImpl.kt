package com.gorkem.cleanarchmovieapp.data.repository

import com.gorkem.cleanarchmovieapp.data.remote.dto.MovieAPI
import com.gorkem.cleanarchmovieapp.data.remote.dto.MovieDetailDto
import com.gorkem.cleanarchmovieapp.data.remote.dto.MoviesDto
import com.gorkem.cleanarchmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imbdId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imbdId)
    }

}