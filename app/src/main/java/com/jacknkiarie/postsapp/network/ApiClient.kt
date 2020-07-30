package com.jacknkiarie.postsapp.network

import com.google.gson.GsonBuilder
import com.jacknkiarie.postsapp.utils.Config
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private fun getRetrofit(url: String) : Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val client = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit
    }

    val getPostClient : PostService
    get() {
        return getRetrofit(Config.BASE_URL).create(PostService::class.java)
    }
}