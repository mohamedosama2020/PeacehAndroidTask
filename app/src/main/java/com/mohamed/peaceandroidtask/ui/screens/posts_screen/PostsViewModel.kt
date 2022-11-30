package com.mohamed.peaceandroidtask.ui.screens.posts_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.peaceandroidtask.entities.posts.toUIModel
import com.mohamed.peaceandroidtask.entities.ui_state.PostsState
import com.mohamed.peaceandroidtask.usecases.GetPostsUseCase
import com.mohamed.peaceandroidtask.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val getUsersUserCase: GetUsersUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PostsState())
    val uiState: StateFlow<PostsState> = _uiState.asStateFlow()

    init {
        getPosts()
    }

    private fun getPosts() = viewModelScope.launch {

        try {
            val responseUsers = getUsersUserCase()
            val responsePosts = getPostsUseCase()
            if (responseUsers.isSuccessful && responsePosts.isSuccessful) {
                if (responsePosts.body() != null) {
                    _uiState.update {
                        it.copy(
                            posts = responsePosts.body()?.toUIModel(responseUsers.body()!!),
                            loading = false
                        )
                    }
                }
            } else {
                _uiState.update {
                    it.copy(posts = null, loading = false, error = "Something Went Wrong")
                }
            }

        } catch (e: java.lang.Exception) {
            _uiState.update {
                it.copy(posts = null, loading = false, error = e.localizedMessage)
            }
        }

    }
}