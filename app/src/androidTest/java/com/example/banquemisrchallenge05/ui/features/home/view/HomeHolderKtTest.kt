package com.example.banquemisrchallenge05.ui.features.home.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.example.banquemisrchallenge05.data_layer.MoviesRepository
import com.example.banquemisrchallenge05.data_layer.MoviesRepositoryImpl
import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSourceImpl
import com.example.banquemisrchallenge05.ui.features.home.view_model.HomeViewModel
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModel
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeHolderKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var repository: MoviesRepository
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var nowPlayingViewModel: NowPlayingViewModel
    private lateinit var popularViewModel: PopularViewModel
    private lateinit var upcomingViewModel: UpcomingViewModel

    @Before
    fun setup() {
        repository =
            MoviesRepositoryImpl.getInstance(
                TMDbRemoteDataSourceImpl.getInstance(),
            )
        homeViewModel = HomeViewModel(repository)
        nowPlayingViewModel = NowPlayingViewModel(repository)
        popularViewModel = PopularViewModel(repository)
        upcomingViewModel = UpcomingViewModel(repository)
    }

    @Test
    fun testTabNavigation() {
        composeTestRule.setContent {
            HomeHolder(
                navController = rememberNavController(),
                homeViewModel = homeViewModel,
                nowPlayingViewModel = nowPlayingViewModel,
                popularViewModel = popularViewModel,
                upcomingViewModel = upcomingViewModel,
            )
        }

        composeTestRule.onNodeWithTag("movies_loading").assertExists()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("now_playing_selected").assertExists()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("popular").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("movies_loading").assertExists()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("popular_selected").assertExists()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("upcoming").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("movies_loading").assertExists()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("upcoming_selected").assertExists()
        Thread.sleep(1000)
    }
}
