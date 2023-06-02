package com.gorkem.cleanarchmovieapp.presentation.movies.views

import com.gorkem.cleanarchmovieapp.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "joker"
)