package com.fikriks.myapp.ui.bookmark.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity

class TvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvs(): LiveData<PagedList<TvEntity>> = movieRepository.getBookmarkedTvs()

    fun setBookmark(tvEntity: TvEntity) {
        val newState = !tvEntity.bookmarked
        movieRepository.setTvBookmark(tvEntity, newState)
    }
}