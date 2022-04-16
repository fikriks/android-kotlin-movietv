package com.fikriks.myapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.vo.Resource

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies()
}