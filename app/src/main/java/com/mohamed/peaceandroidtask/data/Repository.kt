package com.mohamed.peaceandroidtask.data

import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts():Response<String> = apiService.getPosts()
}