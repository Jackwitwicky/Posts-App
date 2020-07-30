package com.jacknkiarie.postsapp.network

import com.jacknkiarie.postsapp.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    fun getPosts() : Call<List<Post>>
}