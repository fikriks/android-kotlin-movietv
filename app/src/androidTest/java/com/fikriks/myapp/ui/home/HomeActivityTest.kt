package com.fikriks.myapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.fikriks.myapp.R
import com.fikriks.myapp.utils.DataDummy
import com.fikriks.myapp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTv = DataDummy.generateDummyTvs()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title_detail)).check(matches(isDisplayed())).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_item_rating_detail)).check(matches(isDisplayed())).check(matches(withText(dummyMovie[0].ratings)))
        onView(withId(R.id.tv_item_duration_detail)).check(matches(isDisplayed())).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.tv_item_year_detail)).check(matches(isDisplayed())).check(matches(withText(dummyMovie[0].year)))
        onView(withId(R.id.tv_item_genre_detail)).check(matches(isDisplayed())).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_item_director_detail)).check(matches(isDisplayed())).check(matches(withText(dummyMovie[0].director)))
        onView(withId(R.id.tv_item_description_detail)).check(matches(isDisplayed())).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadMovieBookmarks() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_duration_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_year_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_genre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_director_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_description_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadTv() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    @Test
    fun loadDetailTv() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title_detail)).check(matches(isDisplayed())).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.tv_item_rating_detail)).check(matches(isDisplayed())).check(matches(withText(dummyTv[0].ratings)))
        onView(withId(R.id.tv_item_year_detail)).check(matches(isDisplayed())).check(matches(withText(dummyTv[0].year)))
        onView(withId(R.id.tv_item_genre_detail)).check(matches(isDisplayed())).check(matches(withText(dummyTv[0].genre)))
        onView(withId(R.id.tv_item_description_detail)).check(matches(isDisplayed())).check(matches(withText(dummyTv[0].description)))
    }

    @Test
    fun loadTvBookmarks() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_year_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_genre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_description_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}