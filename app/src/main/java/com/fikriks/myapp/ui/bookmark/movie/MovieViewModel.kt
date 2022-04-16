package com.fikriks.myapp.ui.bookmark.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.MovieEntity

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<PagedList<MovieEntity>> =  movieRepository.getBookmarkedMovies()

    fun setBookmark(movieEntity: MovieEntity) {
        val newState = !movieEntity.bookmarked
        movieRepository.setMovieBookmark(movieEntity, newState)
    }
}