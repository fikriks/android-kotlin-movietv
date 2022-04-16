package com.fikriks.myapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.utils.DataDummy
import com.fikriks.myapp.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val title = dummyMovie.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieRepository)
        title.let { viewModel.setSelectedMovie(it) }
    }

    @Test
    fun `setSelectedMovie should be success`() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(dummyMovie)

        `when`(movieRepository.getDetailMovie(title)).thenReturn(expected)

        viewModel.movieModule.observeForever(movieObserver)

        verify(movieObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.movieModule.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setBookmark should be success`() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(dummyMovie)

        `when`(movieRepository.getDetailMovie(title)).thenReturn(expected)

        viewModel.movieModule.observeForever(movieObserver)
        viewModel.setBookmark()

        expected.value?.data?.let { verify(movieRepository, Mockito.times(1)).setMovieBookmark(it, true) }
    }
}