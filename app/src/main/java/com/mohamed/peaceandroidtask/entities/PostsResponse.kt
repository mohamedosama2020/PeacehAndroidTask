package com.mohamed.peaceandroidtask.entities

import com.google.gson.annotations.SerializedName

data class PostsResponse(
    @SerializedName("documents")
    var posts: List<Post> = listOf()
)