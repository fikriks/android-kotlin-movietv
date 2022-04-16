package com.fikriks.myapp.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.vo.Resource

class TvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvs(): LiveData<Resource<PagedList<TvEntity>>> = movieRepository.getAllTvs()
}