package com.mohamed.peaceandroidtask.data
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): Response<String>
}