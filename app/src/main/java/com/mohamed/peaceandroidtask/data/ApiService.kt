package com.mohamed.peaceandroidtask.data
import com.mohamed.peaceandroidtask.entities.posts.PostsResponse
import com.mohamed.peaceandroidtask.entities.users.UsersResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<PostsResponse>

    @GET("users")
    suspend fun getUsers(): Response<UsersResponse>
}