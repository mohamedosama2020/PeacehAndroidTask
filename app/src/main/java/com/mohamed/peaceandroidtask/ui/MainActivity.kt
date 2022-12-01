package com.mohamed.peaceandroidtask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohamed.peaceandroidtask.ui.screens.posts_screen.PostListView
import com.mohamed.peaceandroidtask.ui.screens.posts_screen.PostsViewModel
import com.mohamed.peaceandroidtask.ui.theme.PeaceAndroidTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeaceAndroidTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val postsState = viewModel.uiState.collectAsState()
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (postsState.value.posts.isNotEmpty()) {
                            PostListView(
                                uiPosts = postsState.value.posts,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 20.dp),
                            )
                        }
                        if (postsState.value.loading){
                            CircularProgressIndicator(Modifier.size(size = 35.dp))
                        }
                    }

                }
            }
        }
    }
}