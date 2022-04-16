package com.fikriks.myapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.data.source.local.room.MovieDao
import com.fikriks.myapp.vo.Resource

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource{
            if (INSTANCE == null) {
                INSTANCE = LocalDataSource(movieDao)
            }
        return INSTANCE as LocalDataSource
    }
}

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getBookmarkedMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getBookmarkedMovie()

    fun getDetailMovie(title: String): LiveData<MovieEntity> = mMovieDao.getMovieByTitle(title)

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun updateMovie(movie: MovieEntity) {
        mMovieDao.updateMovie(movie)
    }

    fun setMovieBookmark(movie: MovieEntity, newState: Boolean) {
        movie.bookmarked = newState
        mMovieDao.updateMovie(movie)
    }

    fun getAllTvs(): DataSource.Factory<Int, TvEntity> = mMovieDao.getTvs()

    fun getBookmarkedTvs(): DataSource.Factory<Int, TvEntity> = mMovieDao.getBookmarkedTvs()

    fun getDetailTv(title: String): LiveData<TvEntity> = mMovieDao.getTvByTitle(title)

    fun insertTvs(tvs: List<TvEntity>) = mMovieDao.insertTvs(tvs)

    fun updateTv(tv: TvEntity) {
        mMovieDao.updateTv(tv)
    }

    fun setTvBookmark(tv: TvEntity, newState: Boolean) {
        tv.bookmarked = newState
        mMovieDao.updateTv(tv)
    }
}