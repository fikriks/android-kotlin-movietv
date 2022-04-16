package com.fikriks.myapp.ui.tv

import com.fikriks.myapp.data.source.local.entity.TvEntity

interface TvFragmentCallback {
    fun onShareClick(course: TvEntity)
}