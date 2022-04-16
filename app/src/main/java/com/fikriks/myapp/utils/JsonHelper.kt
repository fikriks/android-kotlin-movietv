package com.fikriks.myapp.utils

import android.content.Context
import com.fikriks.myapp.data.source.remote.response.MovieResponse
import com.fikriks.myapp.data.source.remote.response.TvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val poster = movie.getString("poster")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val duration = movie.getString("duration")
                val year = movie.getString("year")
                val ratings = movie.getString("ratings")
                val genre = movie.getString("genre")
                val director = movie.getString("director")

                val movieResponse = MovieResponse(poster, title, description, duration, year, ratings, genre, director)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailMovie(title: String): MovieResponse {
        var movieResponse: MovieResponse? = null
        try {
            val results = this.loadMovies()
            for (i in results.indices) {
                if (results[i].title == title) {
                    val poster = results[i].poster
                    val title = results[i].title
                    val description = results[i].description
                    val duration = results[i].duration
                    val year = results[i].year
                    val ratings = results[i].ratings
                    val genre = results[i].genre
                    val director = results[i].director

                    movieResponse = MovieResponse(poster, title, duration, description, year, ratings, genre, director)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieResponse as MovieResponse
    }

    fun loadTvs(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvs")
            for (i in 0 until listArray.length()) {
                val tv = listArray.getJSONObject(i)

                val poster = tv.getString("poster")
                val title = tv.getString("title")
                val description = tv.getString("description")
                val year = tv.getString("year")
                val ratings = tv.getString("ratings")
                val genre = tv.getString("genre")

                val tvResponse = TvResponse(poster, title, description, year, ratings, genre)
                list.add(tvResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadDetailTv(title: String): TvResponse {
        var tvResponse: TvResponse? = null
        try {
            val results = this.loadTvs()
            for (i in results.indices) {
                if (results[i].title == title) {
                    val poster = results[i].poster
                    val title = results[i].title
                    val description = results[i].description
                    val year = results[i].year
                    val ratings = results[i].ratings
                    val genre = results[i].genre
                    tvResponse = TvResponse(poster, title, description, year, ratings, genre)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return tvResponse as TvResponse
    }
}