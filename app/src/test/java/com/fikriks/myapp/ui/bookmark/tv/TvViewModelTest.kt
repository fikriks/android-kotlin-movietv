package com.fikriks.myapp.ui.bookmark.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.utils.DataDummy
import com.fikriks.myapp.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest{
    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvEntity>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieRepository)
    }

    @Test
    fun `getTvs should be success`() {
        val expected = MutableLiveData<PagedList<TvEntity>>()
        expected.value = PagedTestDataSources.snapshot(DataDummy.generateDummyTvs())

        `when`(movieRepository.getBookmarkedTvs()).thenReturn(expected)

        viewModel.getTvs().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getTvs().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getTvs should be success but data is empty`() {
        val expected = MutableLiveData<PagedList<TvEntity>>()
        expected.value = PagedTestDataSources.snapshot()

        `when`(movieRepository.getBookmarkedTvs()).thenReturn(expected)

        viewModel.getTvs().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getTvs().value?.size
        Assert.assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    @Test
    fun setBookmark() {
        val dummyTvs = MutableLiveData<TvEntity>()
        dummyTvs.value = DataDummy.generateDummyTvs()[0]
        val tvEntities = LiveDataTestUtil.getValue(dummyTvs)

        viewModel.setBookmark(tvEntities)

        verify(movieRepository, Mockito.times(1)).setTvBookmark(tvEntities, true)
    }

    class PagedTestDataSources private constructor(private val items: List<TvEntity>) : PositionalDataSource<TvEntity>() {
        companion object {
            fun snapshot(items: List<TvEntity> = listOf()): PagedList<TvEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<TvEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TvEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}