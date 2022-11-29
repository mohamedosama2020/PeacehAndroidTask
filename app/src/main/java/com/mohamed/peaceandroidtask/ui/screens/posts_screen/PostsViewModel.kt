package com.mohamed.peaceandroidtask.ui.screens.posts_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.peaceandroidtask.usecases.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) : ViewModel()  {

    fun getPosts() = viewModelScope.launch {
        val response = getPostsUseCase()
        if(response.isSuccessful){
            // OK
        }else{
            // ERROR
        }
    }
}