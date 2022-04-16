package com.fikriks.myapp.ui.bookmark.movie

import com.fikriks.myapp.data.source.local.entity.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(course: MovieEntity)
}