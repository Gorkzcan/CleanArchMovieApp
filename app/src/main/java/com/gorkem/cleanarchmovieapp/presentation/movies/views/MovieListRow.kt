package com.gorkem.cleanarchmovieapp.presentation.movies.views

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.gorkem.cleanarchmovieapp.domain.model.Movie

@Composable
fun MovieListRow(
    movie: Movie,
    onItemClick : (Movie) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(movie)
            }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = rememberAsyncImagePainter(model = movie.Poster), contentDescription = movie.Title,
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp, 200.dp)
            .clip(RectangleShape))

        Column(
            modifier =  Modifier.align(CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = movie.Title,
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color= Color.White,
            textAlign = TextAlign.Center)

            Text(text = movie.Year,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                color= Color.White,
                textAlign = TextAlign.Center)
        }
    }
}