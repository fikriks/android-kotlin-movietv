package com.fikriks.myapp.ui.movie

import com.fikriks.myapp.data.source.local.entity.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(course: MovieEntity)
}