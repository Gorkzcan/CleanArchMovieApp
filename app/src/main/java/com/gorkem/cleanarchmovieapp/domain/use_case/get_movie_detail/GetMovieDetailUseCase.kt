package com.gorkem.cleanarchmovieapp.domain.use_case.get_movie_detail

import com.gorkem.cleanarchmovieapp.data.remote.dto.toMovieDetail
import com.gorkem.cleanarchmovieapp.data.remote.dto.toMovieList
import com.gorkem.cleanarchmovieapp.domain.model.Movie
import com.gorkem.cleanarchmovieapp.domain.model.MovieDetail
import com.gorkem.cleanarchmovieapp.domain.repository.MovieRepository
import com.gorkem.cleanarchmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository){

    fun executeGetMovieDetail(imbdId: String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imbdId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e : IOError){
            emit(Resource.Error(message = "No internet connection"))
        }catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}