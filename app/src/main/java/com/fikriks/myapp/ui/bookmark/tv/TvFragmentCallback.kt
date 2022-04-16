package com.fikriks.myapp.ui.bookmark.tv

import com.fikriks.myapp.data.source.local.entity.TvEntity

interface TvFragmentCallback {
    fun onShareClick(course: TvEntity)
}