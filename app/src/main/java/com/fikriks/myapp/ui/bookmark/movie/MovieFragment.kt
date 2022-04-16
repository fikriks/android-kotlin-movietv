package com.fikriks.myapp.ui.bookmark.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fikriks.myapp.R
import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.databinding.FragmentMovieBinding
import com.fikriks.myapp.ui.bookmark.movie.MovieViewModel as BookmarkMovieViewModel
import com.fikriks.myapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment :  Fragment(), MovieFragmentCallback {
    private var fragmentMovieBinding: FragmentMovieBinding? = null
    private lateinit var viewModel: BookmarkMovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentMovieBinding?.rvMovie)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[BookmarkMovieViewModel::class.java]

            movieAdapter = MovieAdapter(this)
            fragmentMovieBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.getMovies().observe(this, { movies ->
                fragmentMovieBinding?.progressBar?.visibility = View.GONE
                movieAdapter.submitList(movies)
                movieAdapter.notifyDataSetChanged()
            })

            fragmentMovieBinding?.rvMovie?.layoutManager = LinearLayoutManager(context)
            fragmentMovieBinding?.rvMovie?.setHasFixedSize(true)
            fragmentMovieBinding?.rvMovie?.adapter = movieAdapter
        }
    }

    override fun onShareClick(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText("Bagikan film ${movie.title}")
                .startChooser()
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = movieAdapter.getSwipedData(swipedPosition)
                movieEntity?.let { viewModel.setBookmark(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    movieEntity?.let { viewModel.setBookmark(it) }
                }
                snackbar.show()
            }
        }
    })
}