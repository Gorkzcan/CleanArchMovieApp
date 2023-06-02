package com.gorkem.cleanarchmovieapp.presentation.movie_detail

import com.gorkem.cleanarchmovieapp.domain.model.Movie
import com.gorkem.cleanarchmovieapp.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = ""
)