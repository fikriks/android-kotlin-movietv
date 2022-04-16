package com.fikriks.myapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.vo.Resource

interface MovieDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getBookmarkedMovies(): LiveData<PagedList<MovieEntity>>

    fun getDetailMovie(title: String) : LiveData<Resource<MovieEntity>>

    fun setMovieBookmark(movie: MovieEntity, state: Boolean)

    fun getAllTvs(): LiveData<Resource<PagedList<TvEntity>>>

    fun getBookmarkedTvs(): LiveData<PagedList<TvEntity>>

    fun getDetailTv(title: String) : LiveData<Resource<TvEntity>>

    fun setTvBookmark(tv: TvEntity, state: Boolean)
}