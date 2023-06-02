package com.gorkem.cleanarchmovieapp.presentation.movies.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorkem.cleanarchmovieapp.domain.use_case.get_movies.GetMovieUseCase
import com.gorkem.cleanarchmovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state: State<MoviesState> = _state

    private var job: Job? = null
//en başta boş bir job yaratıyoruz. daha sonra eğer bir job varsa arama yapılabilmesi için iptal ediyoruz.
    //arama yapılırken yeni job olarak o aramayı atıyoruz.

    init {
        getMovies(_state.value.search)
    }
    private fun getMovies(search: String) {
        job?.cancel()
        job = getMovieUseCase.executeGetMovies(search).onEach {
            //her veri geldiğinde
            when(it){
                is Resource.Success -> {
                    _state.value = MoviesState(movies = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MoviesState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }

    fun onEvent(event: MoviesEvent){
        when(event){
            is MoviesEvent.Search -> {
                getMovies(event.searchString)
            }
            else -> {}
        }
    }
}