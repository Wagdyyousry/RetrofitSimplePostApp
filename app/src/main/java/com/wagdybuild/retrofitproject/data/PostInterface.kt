package com.wagdybuild.retrofitproject.data

import com.wagdybuild.retrofitproject.models.Comment2
import com.wagdybuild.retrofitproject.models.Post2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostInterface {
    @GET("posts")
    suspend fun getPosts(): List<Post2>
    @GET("comments")
    suspend fun getComments(@Query("postId") postId: String):List<Comment2>
}