package com.fikriks.myapp.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fikriks.myapp.data.source.remote.response.MovieResponse
import com.fikriks.myapp.data.source.remote.response.TvResponse
import com.fikriks.myapp.utils.EspressoIdlingResource
import com.fikriks.myapp.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement() }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getDetailMovie(title: String): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadDetailMovie(title))
            EspressoIdlingResource.decrement() }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getAllTvs(): LiveData<ApiResponse<List<TvResponse>>> {
        EspressoIdlingResource.increment()
        val resultTv = MutableLiveData<ApiResponse<List<TvResponse>>>()
        handler.postDelayed({
            resultTv.value = ApiResponse.success(jsonHelper.loadTvs())
            EspressoIdlingResource.decrement() }, SERVICE_LATENCY_IN_MILLIS)
        return resultTv
    }

    fun getDetailTv(title: String): LiveData<ApiResponse<TvResponse>> {
        EspressoIdlingResource.increment()
        val resultTv = MutableLiveData<ApiResponse<TvResponse>>()
        handler.postDelayed({
            resultTv.value = ApiResponse.success(jsonHelper.loadDetailTv(title))
            EspressoIdlingResource.decrement() }, SERVICE_LATENCY_IN_MILLIS)
        return resultTv
    }
}