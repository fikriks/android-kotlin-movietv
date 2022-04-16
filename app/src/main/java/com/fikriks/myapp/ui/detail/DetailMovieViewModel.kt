package com.fikriks.myapp.ui.detail

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.vo.Resource

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var movieModule: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        movieRepository.getDetailMovie(mMovieId)
    }

    fun setBookmark() {
        val movieResource = movieModule.value
        if (movieResource != null) {
            val movie = movieResource.data
            if (movie != null) {
                val movieEntity = movieResource.data
                val newState = !movieEntity.bookmarked
                movieRepository.setMovieBookmark(movieEntity, newState)
            }
        }
    }
}