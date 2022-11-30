package com.mohamed.peaceandroidtask.usecases

import com.mohamed.peaceandroidtask.data.Repository
import com.mohamed.peaceandroidtask.entities.posts.PostsResponse
import retrofit2.Response
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repo: Repository) {
    suspend operator fun invoke(): Response<PostsResponse> {
        return repo.getPosts()
    }
}