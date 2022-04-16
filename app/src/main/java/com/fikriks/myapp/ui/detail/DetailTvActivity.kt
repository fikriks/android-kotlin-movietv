package com.fikriks.myapp.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fikriks.myapp.R
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.databinding.ActivityDetailTvBinding
import com.fikriks.myapp.databinding.ContentDetailTvBinding
import com.fikriks.myapp.viewmodel.ViewModelFactory
import com.fikriks.myapp.vo.Status

class DetailTvActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private var activityDetailTvBinding: ActivityDetailTvBinding? = null
    private var detailContentBinding: ContentDetailTvBinding? = null
    private lateinit var viewModel: DetailTvViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvBinding = ActivityDetailTvBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvBinding?.detailContent

        setContentView(activityDetailTvBinding?.root)

        setSupportActionBar(activityDetailTvBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.detail_tv)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvId = extras.getString(EXTRA_TV)
            if (tvId != null) {
                viewModel.setSelectedTv(tvId)

                viewModel.tvModule.observe(this, { tvResource ->
                    if (tvResource != null) {
                        when (tvResource.status) {
                            Status.LOADING -> activityDetailTvBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> if (tvResource.data != null) {
                                activityDetailTvBinding?.progressBar?.visibility = View.GONE
                                activityDetailTvBinding?.content?.visibility = View.VISIBLE

                                populateTv(tvResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailTvBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Something Error", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateTv(tvEntity: TvEntity) {
        detailContentBinding?.tvItemTitleDetail?.text = tvEntity.title
        detailContentBinding?.tvItemRatingDetail?.text = tvEntity.ratings
        detailContentBinding?.tvItemYearDetail?.text = tvEntity.year
        detailContentBinding?.tvItemGenreDetail?.text = tvEntity.genre
        detailContentBinding?.tvItemDescriptionDetail?.text = tvEntity.description

        detailContentBinding?.imgItemDetail?.let {
            Glide.with(this)
                .load(tvEntity.poster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.tvModule.observe(this, { tv ->
            if (tv != null) {
                when (tv.status) {
                    Status.LOADING -> activityDetailTvBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> if (tv.data != null) {
                        activityDetailTvBinding?.progressBar?.visibility = View.GONE
                        val state = tv.data.bookmarked
                        setBookmarkState(state)
                    }
                    Status.ERROR -> {
                        activityDetailTvBinding?.progressBar?.visibility = View.GONE
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