package com.fikriks.myapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fikriks.myapp.R
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.databinding.ActivityDetailMovieBinding
import com.fikriks.myapp.databinding.ContentDetailMovieBinding
import com.fikriks.myapp.viewmodel.ViewModelFactory
import com.fikriks.myapp.vo.Status

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private var activityDetailMovieBinding: ActivityDetailMovieBinding? = null
    private var detailContentBinding: ContentDetailMovieBinding? = null
    private lateinit var viewModel: DetailMovieViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding?.detailContent

        setContentView(activityDetailMovieBinding?.root)

        setSupportActionBar(activityDetailMovieBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.detail_movie)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)

                viewModel.movieModule.observe(this, { movieResource ->
                    if (movieResource != null) {
                        when (movieResource.status) {
                            Status.LOADING -> activityDetailMovieBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> if (movieResource.data != null) {
                                activityDetailMovieBinding?.progressBar?.visibility = View.GONE
                                activityDetailMovieBinding?.content?.visibility = View.VISIBLE

                                populateMovie(movieResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailMovieBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Something Error", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding?.tvItemTitleDetail?.text = movieEntity.title
        detailContentBinding?.tvItemRatingDetail?.text = movieEntity.ratings
        detailContentBinding?.tvItemDurationDetail?.text = movieEntity.duration
        detailContentBinding?.tvItemYearDetail?.text = movieEntity.year
        detailContentBinding?.tvItemGenreDetail?.text = movieEntity.genre
        detailContentBinding?.tvItemDirectorDetail?.text = movieEntity.director
        detailContentBinding?.tvItemDescriptionDetail?.text = movieEntity.description

        detailContentBinding?.imgItemDetail?.let {
            Glide.with(this)
                .load(movieEntity.poster)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.movieModule.observe(this, { movie ->
            if (movie != null) {
                when (movie.status) {
                    Status.LOADING -> activityDetailMovieBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> if (movie.data != null) {
                        activityDetailMovieBinding?.progressBar?.visibility = View.GONE
                        val state = movie.data.bookmarked
                        setBookmarkState(state)
                    }
                    Status.ERROR -> {
                        activityDetailMovieBinding?.progressBar?.visibility = View.GONE
                        Toast.makeText(applicationContext, "Something Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        if (item.itemId == R.id.action_bookmark) {
            viewModel.setBookmark()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white)
        }
    }
}