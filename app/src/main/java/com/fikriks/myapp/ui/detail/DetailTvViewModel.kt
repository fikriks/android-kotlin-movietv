package com.fikriks.myapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fikriks.myapp.data.MovieRepository
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.vo.Resource

class DetailTvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val tvId = MutableLiveData<String>()

    fun setSelectedTv(tvId: String) {
        this.tvId.value = tvId
    }

    var tvModule: LiveData<Resource<TvEntity>> = Transformations.switchMap(tvId) { mTvId ->
        movieRepository.getDetailTv(mTvId)
    }

    fun setBookmark() {
        val tvResource = tvModule.value
        if (tvResource != null) {
            val tv = tvResource.data
            if (tv != null) {
                val tvEntity = tvResource.data
                val newState = !tvEntity.bookmarked
                movieRepository.setTvBookmark(tvEntity, newState)
            }
        }
    }
}