package com.fikriks.myapp.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tventities")
class TvEntity(
        @ColumnInfo(name = "poster")
        var poster: String,

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "year")
        var year: String,

        @ColumnInfo(name = "ratings")
        var ratings: String,

        @ColumnInfo(name = "genre")
        var genre: String,

        @ColumnInfo(name = "bookmarked")
        var bookmarked: Boolean = false
)