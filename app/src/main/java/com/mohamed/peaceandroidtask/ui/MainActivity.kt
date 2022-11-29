package com.mohamed.peaceandroidtask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.mohamed.peaceandroidtask.entities.uiPosts
import com.mohamed.peaceandroidtask.ui.screens.posts_screen.PostListView
import com.mohamed.peaceandroidtask.ui.theme.PeaceAndroidTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeaceAndroidTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PostListView(uiPosts,Modifier.fillMaxSize())
                }
            }
        }
    }
}