package com.mohamed.peaceandroidtask.entities.posts

import com.google.gson.annotations.SerializedName
import com.mohamed.peaceandroidtask.entities.users.UsersResponse

data class PostsResponse(
    @SerializedName("documents")
    var posts: List<Post> = listOf()
)

fun PostsResponse.toUIModel(usersResponse: UsersResponse): List<UiPost> {
    return this.posts.map { post ->
        val author = usersResponse.users.find { it.name.contains(post.fields.authorID.stringValue) }
        UiPost(
            post.name,
            if(post.fields.mediaType.stringValue == "photo") post.fields.storageRef.stringValue else "",
            post.fields.createdAt.timestampValue,
            post.fields.caption.stringValue,
            "",
            post.fields.comments.arrayValue.values.size,
            Author(name = author?.fields?.username?.stringValue!!, email = author.fields.email.stringValue)
        )
    }
}