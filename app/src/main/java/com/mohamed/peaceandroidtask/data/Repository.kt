package com.mohamed.peaceandroidtask.data

import com.mohamed.peaceandroidtask.entities.posts.PostsResponse
import com.mohamed.peaceandroidtask.entities.users.UsersResponse
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts():Response<PostsResponse> = apiService.getPosts()

    suspend fun getUsers(): Response<UsersResponse> = apiService.getUsers()
}