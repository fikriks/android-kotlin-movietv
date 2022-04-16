package com.fikriks.myapp.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fikriks.myapp.data.source.local.LocalDataSource
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.data.source.remote.ApiResponse
import com.fikriks.myapp.data.source.remote.RemoteDataSource
import com.fikriks.myapp.data.source.remote.response.MovieResponse
import com.fikriks.myapp.data.source.remote.response.TvResponse
import com.fikriks.myapp.utils.AppExecutors
import com.fikriks.myapp.vo.Resource

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
                                                   private val appExecutors: AppExecutors
) :
    MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>{
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }
            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()
            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()
            public override fun saveCallResult(movieResponses: List<MovieResponse>) {
                val movieList = java.util.ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(response.poster,
                            response.title,
                            response.description,
                            response.duration,
                            response.year,
                            response.ratings,
                            response.genre,
                            response.director)
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(title: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors) {
            public override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(title)
            override fun shouldFetch(movieEntity: MovieEntity?): Boolean =
                movieEntity == null
            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getDetailMovie(title)
            override fun saveCallResult(response: MovieResponse) {
                val movie = MovieEntity(response.poster,
                    response.title,
                    response.description,
                    response.duration,
                    response.year,
                    response.ratings,
                    response.genre,
                    response.director)

                localDataSource.updateMovie(movie)
            }
        }.asLiveData()
    }

    override fun getAllTvs(): LiveData<Resource<PagedList<TvEntity>>> {
        return object : NetworkBoundResource<PagedList<TvEntity>, List<TvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvEntity>>{
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvs(), config).build()
            }
            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean =
                data == null || data.isEmpty()
            public override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getAllTvs()
            public override fun saveCallResult(tvResponses: List<TvResponse>) {
                val tvList = java.util.ArrayList<TvEntity>()
                for (response in tvResponses) {
                    val tv = TvEntity(response.poster,
                        response.title,
                        response.description,
                        response.year,
                        response.ratings,
                        response.genre)
                    tvList.add(tv)
                }
                localDataSource.insertTvs(tvList)
            }
        }.asLiveData()
    }

    override fun getDetailTv(title: String): LiveData<Resource<TvEntity>> {
        return object : NetworkBoundResource<TvEntity, TvResponse>(appExecutors) {
            public override fun loadFromDB(): LiveData<TvEntity> =
                localDataSource.getDetailTv(title)
            override fun shouldFetch(tvEntity: TvEntity?): Boolean =
                tvEntity == null
            override fun createCall(): LiveData<ApiResponse<TvResponse>> =
                remoteDataSource.getDetailTv(title)
            override fun saveCallResult(response: TvResponse) {
                val tv = TvEntity(response.poster,
                    response.title,
                    response.description,
                    response.year,
                    response.ratings,
                    response.genre)

                localDataSource.updateTv(tv)
            }
        }.asLiveData()
    }

    override fun getBookmarkedMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), config).build()
    }

    override fun getBookmarkedTvs(): LiveData<PagedList<TvEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedTvs(), config).build()
    }

    override fun setMovieBookmark(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieBookmark(movie, state) }

    override fun setTvBookmark(tv: TvEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvBookmark(tv, state) }
}