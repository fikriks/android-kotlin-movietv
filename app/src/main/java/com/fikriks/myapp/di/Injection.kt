package com.fikriks.myapp.di

import android.content.Context
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.LocalDataSource
import com.fikriks.myapp.data.source.local.room.MovieDatabase
import com.fikriks.myapp.data.source.remote.RemoteDataSource
import com.fikriks.myapp.utils.AppExecutors
import com.fikriks.myapp.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}