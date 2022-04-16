package com.fikriks.myapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.utils.DataDummy
import com.fikriks.myapp.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvViewModelTest{
    private lateinit var viewModel: DetailTvViewModel
    private val dummyTv = DataDummy.generateDummyTvs()[0]
    private val title = dummyTv.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var tvObserver: Observer<Resource<TvEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvViewModel(movieRepository)
        title.let { viewModel.setSelectedTv(it) }
    }

    @Test
    fun `setSelectedTv should be success`() {
        val expected = MutableLiveData<Resource<TvEntity>>()
        expected.value = Resource.success(dummyTv)

        Mockito.`when`(movieRepository.getDetailTv(title)).thenReturn(expected)

        viewModel.tvModule.observeForever(tvObserver)

        Mockito.verify(tvObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.tvModule.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setBookmark should be success`() {
        val expected = MutableLiveData<Resource<TvEntity>>()
        expected.value = Resource.success(dummyTv)

        Mockito.`when`(movieRepository.getDetailTv(title)).thenReturn(expected)

        viewModel.tvModule.observeForever(tvObserver)
        viewModel.setBookmark()

        expected.value?.data?.let { Mockito.verify(movieRepository, Mockito.times(1)).setTvBookmark(it, true) }
    }
}