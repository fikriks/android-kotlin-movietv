package com.fikriks.myapp.ui.bookmark.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fikriks.myapp.R
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.databinding.FragmentTvBinding
import com.fikriks.myapp.ui.bookmark.tv.TvAdapter
import com.fikriks.myapp.ui.bookmark.tv.TvFragmentCallback
import com.fikriks.myapp.ui.bookmark.tv.TvViewModel as BookmarkTvModel
import com.fikriks.myapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment(), TvFragmentCallback {
    private var fragmentTvBinding: FragmentTvBinding? = null
    private lateinit var viewModel: BookmarkTvModel
    private lateinit var tvAdapter: TvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentTvBinding?.rvTv)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[BookmarkTvModel::class.java]

            tvAdapter = TvAdapter(this)
            fragmentTvBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.getTvs().observe(this, { tvs ->
                fragmentTvBinding?.progressBar?.visibility = View.GONE
                tvAdapter.submitList(tvs)
                tvAdapter.notifyDataSetChanged()
            })

            fragmentTvBinding?.rvTv?.layoutManager = LinearLayoutManager(context)
            fragmentTvBinding?.rvTv?.setHasFixedSize(true)
            fragmentTvBinding?.rvTv?.adapter = tvAdapter
        }
    }

    override fun onShareClick(tv: TvEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText("Bagikan acara TV ${tv.title}")
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
                val tvEntity = tvAdapter.getSwipedData(swipedPosition)
                tvEntity?.let { viewModel.setBookmark(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    tvEntity?.let { viewModel.setBookmark(it) }
                }
                snackbar.show()
            }
        }
    })
}