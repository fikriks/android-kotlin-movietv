package com.fikriks.myapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where bookmarked = 1")
    fun getBookmarkedMovie():  DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE title = :title")
    fun getMovieByTitle(title: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM tventities")
    fun getTvs():  DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tventities where bookmarked = 1")
    fun getBookmarkedTvs():  DataSource.Factory<Int, TvEntity>

    @Transaction
    @Query("SELECT * FROM tventities WHERE title = :title")
    fun getTvByTitle(title: String): LiveData<TvEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvs(tvs: List<TvEntity>)

    @Update
    fun updateTv(tv: TvEntity)
}