package com.mohamed.peaceandroidtask.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mohamed.peaceandroidtask.ui.screens.posts_screen.PostsScreen
import com.mohamed.peaceandroidtask.ui.theme.PeaceAndroidTaskTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testCompose() {
        // Start the app
        composeTestRule.setContent {
            PeaceAndroidTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PostsScreen(
                        viewModel = viewModel(), modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 20.dp)
                    )
                }
            }

            composeTestRule.waitForIdle()
            composeTestRule.onNodeWithText("Comments").performClick()
            composeTestRule.waitForIdle()
            composeTestRule.onNodeWithTag("BottomSheet").assertIsDisplayed()
        }
    }
}