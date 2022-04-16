package com.fikriks.myapp.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.fikriks.myapp.R
import com.fikriks.myapp.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityBookmarkBinding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(activityBookmarkBinding.root)

        val sectionsPagerAdapter = SectionBookmarkAdapter(this, supportFragmentManager)
        activityBookmarkBinding.viewPager.adapter = sectionsPagerAdapter
        activityBookmarkBinding.tabs.setupWithViewPager(activityBookmarkBinding.viewPager)

        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.bookmark)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()

        return super.onOptionsItemSelected(item)
    }
}