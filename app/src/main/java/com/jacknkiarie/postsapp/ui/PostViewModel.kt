package com.jacknkiarie.postsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jacknkiarie.postsapp.models.Post
import com.jacknkiarie.postsapp.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val postRepository = PostRepository()
    var postsResponse = MutableLiveData<List<Post>>()

    fun getPosts() {
        viewModelScope.launch {
            postRepository.getPosts { posts -> postsResponse.value = posts }
        }
    }

}