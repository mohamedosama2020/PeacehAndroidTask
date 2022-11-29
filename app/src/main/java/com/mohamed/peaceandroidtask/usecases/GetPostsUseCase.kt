package com.mohamed.peaceandroidtask.usecases

import com.mohamed.peaceandroidtask.data.Repository
import retrofit2.Response
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repo: Repository) {
    suspend operator fun invoke(): Response<String> {
        return repo.getPosts()
    }
}