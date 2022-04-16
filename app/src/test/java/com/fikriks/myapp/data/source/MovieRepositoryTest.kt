package com.fikriks.myapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.fikriks.myapp.data.source.local.LocalDataSource
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.data.source.remote.RemoteDataSource
import com.fikriks.myapp.utils.AppExecutors
import com.fikriks.myapp.utils.DataDummy
import com.fikriks.myapp.utils.LiveDataTestUtil
import com.fikriks.myapp.utils.PagedListUtil
import com.fikriks.myapp.vo.Resource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class MovieRepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieTitle = movieResponses[0].title
    private val tvResponses = DataDummy.generateRemoteDummyTvs()
    private val tvTitle = tvResponses[0].title

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities =  Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovies = MutableLiveData<MovieEntity>()
        dummyMovies.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getDetailMovie(movieTitle)).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieTitle))
        verify(local).getDetailMovie(movieTitle)
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses[0].title, movieEntities.data?.title)
    }

    @Test
    fun getAllTvs() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getAllTvs()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvs()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvs()))
        verify(local).getAllTvs()
        assertNotNull(tvEntities.data)
        assertEquals(tvResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTv() {
        val dummyTvs = MutableLiveData<TvEntity>()
        dummyTvs.value = DataDummy.generateDummyTvs()[0]
        `when`(local.getDetailTv(tvTitle)).thenReturn(dummyTvs)

        val tvEntities = LiveDataTestUtil.getValue(movieRepository.getDetailTv(tvTitle))

        verify(local).getDetailTv(tvTitle)
        assertNotNull(tvEntities.data)
        assertEquals(tvResponses[0].title, tvEntities.data?.title)
    }

    @Test
    fun getBookmarkedMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getBookmarkedMovies()).thenReturn(dataSourceFactory)
        movieRepository.getBookmarkedMovies()
        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getBookmarkedMovies()
        assertNotNull(movieEntity)
        assertEquals(movieResponses.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getBookmarkedTvs() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getBookmarkedTvs()).thenReturn(dataSourceFactory)
        movieRepository.getBookmarkedTvs()
        val tvEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvs()))
        verify(local).getBookmarkedTvs()
        assertNotNull(tvEntity)
        assertEquals(tvResponses.size.toLong(), tvEntity.data?.size?.toLong())
    }

    @Test
    fun setMovieBookmark() {
        val dummyMovies = MutableLiveData<MovieEntity>()
        dummyMovies.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getDetailMovie(movieTitle)).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(dummyMovies)
        val newState: Boolean = !movieEntities.bookmarked

        doNothing().`when`(local).setMovieBookmark(movieEntities, newState)
        movieRepository.setMovieBookmark(movieEntities, newState)

        verify(local, times(1)).setMovieBookmark(movieEntities, true)
    }

    @Test
    fun setTvBookmark() {
        val dummyTvs = MutableLiveData<TvEntity>()
        dummyTvs.value = DataDummy.generateDummyTvs()[0]
        `when`(local.getDetailTv(tvTitle)).thenReturn(dummyTvs)

        val tvEntities = LiveDataTestUtil.getValue(dummyTvs)
        val newState: Boolean = !tvEntities.bookmarked

        doNothing().`when`(local).setTvBookmark(tvEntities, newState)
        movieRepository.setTvBookmark(tvEntities, newState)

        verify(local, times(1)).setTvBookmark(tvEntities, true)
    }
}