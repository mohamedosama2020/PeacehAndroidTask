package com.mohamed.peaceandroidtask.usecases

import com.mohamed.peaceandroidtask.data.Repository
import com.mohamed.peaceandroidtask.entities.users.UsersResponse
import retrofit2.Response
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repo: Repository) {
    suspend operator fun invoke(): Response<UsersResponse> {
        return repo.getUsers()
    }
}