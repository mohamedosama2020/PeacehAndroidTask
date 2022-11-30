package com.mohamed.peaceandroidtask.entities.users

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("documents")
    val users: List<User> = listOf()
)