package com.gorkem.cleanarchmovieapp.data.remote.dto

import com.gorkem.cleanarchmovieapp.domain.model.Movie


data class MoviesDto(

    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)


fun MoviesDto.toMovieList(): List<Movie>{
    return Search.map { search -> Movie(search.Poster, search.Title, search.imdbID, search.Year) }
}