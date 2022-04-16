package com.fikriks.myapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.di.Injection
import com.fikriks.myapp.ui.detail.DetailMovieViewModel
import com.fikriks.myapp.ui.detail.DetailTvViewModel
import com.fikriks.myapp.ui.movie.MovieViewModel
import com.fikriks.myapp.ui.tv.TvViewModel
import com.fikriks.myapp.ui.bookmark.movie.MovieViewModel as BookmarkMovieViewModel
import com.fikriks.myapp.ui.bookmark.tv.TvViewModel as BookmarkTvViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                TvViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkMovieViewModel::class.java) -> {
                BookmarkMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkTvViewModel::class.java) -> {
                BookmarkTvViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvViewModel::class.java) -> {
                DetailTvViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}