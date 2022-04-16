package com.fikriks.myapp.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse(
    var poster: String,
    var title: String,
    var description: String,
    var year: String,
    var ratings: String,
    var genre: String
): Parcelable