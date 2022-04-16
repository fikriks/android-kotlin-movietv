package com.fikriks.myapp.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity

    @Database(entities = [MovieEntity::class, TvEntity::class],
        version = 1,
        exportSchema = false)
    abstract class MovieDatabase : RoomDatabase() {
        abstract fun movieDao(): MovieDao

        companion object {

            @Volatile
            private var INSTANCE: MovieDatabase? = null

            fun getInstance(context: Context): MovieDatabase{
                if (INSTANCE == null) {
                    synchronized(MovieDatabase::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = Room.databaseBuilder(context.applicationContext,
                                MovieDatabase::class.java, "Movies.db")
                                .build()
                        }
                    }
                }
                return INSTANCE as MovieDatabase
            }
        }
    }