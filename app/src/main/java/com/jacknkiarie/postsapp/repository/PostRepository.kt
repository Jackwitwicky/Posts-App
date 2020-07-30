package com.jacknkiarie.postsapp.repository

import android.util.Log
import com.jacknkiarie.postsapp.models.Post
import com.jacknkiarie.postsapp.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {

    suspend fun getPosts(callback: (List<Post>) -> Unit) = withContext(Dispatchers.IO) {
        val call = ApiClient.getPostClient.getPosts()
        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("POST", "An error occurred while fetching posts")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.body() == null) {
                    Log.d("POST", "The endpoint did not return any data")
                }
                else {
                    callback(response.body()!!)
                }
            }
        })
    }
}