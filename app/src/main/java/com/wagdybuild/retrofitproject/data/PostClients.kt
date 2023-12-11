package com.wagdybuild.retrofitproject.data

import com.wagdybuild.retrofitproject.models.Comment2
import com.wagdybuild.retrofitproject.models.Post2
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class PostClients {
    companion object {
        //private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
        private const val BASE_URL = "https://jsonplaceholder.org/"
    }
    private val api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PostInterface::class.java)
    }
    suspend fun getPosts(): List<Post2> = api.getPosts()
    suspend fun getComments(postId: String):List<Comment2> = api.getComments(postId)


}