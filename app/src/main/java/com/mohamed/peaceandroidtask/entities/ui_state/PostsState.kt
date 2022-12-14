package com.mohamed.peaceandroidtask.entities.ui_state

import com.mohamed.peaceandroidtask.entities.posts.UiPost

data class PostsState(
    val posts:List<UiPost> = listOf(),
    val loading:Boolean = true,
    val error:String? = null
)
