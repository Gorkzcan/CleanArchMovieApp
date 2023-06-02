package com.gorkem.cleanarchmovieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gorkem.cleanarchmovieapp.presentation.movies.views.MovieDetailScreen
import com.gorkem.cleanarchmovieapp.presentation.movies.views.MovieScreen
import com.gorkem.cleanarchmovieapp.presentation.theme.CleanArchMovieAppTheme
import com.gorkem.cleanarchmovieapp.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchMovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route){
                        composable(route = Screen.MovieScreen.route){
                            //movies list
                            MovieScreen(navController = navController)
                        }
                        composable(route = Screen.MovieDetailScreen.route+"/{${IMDB_ID}}"){
                            //movie detail
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

