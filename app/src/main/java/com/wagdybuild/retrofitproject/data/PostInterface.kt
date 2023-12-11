package com.wagdybuild.retrofitproject.data;

import com.wagdybuild.retrofitproject.models.Comment;
import com.wagdybuild.retrofitproject.models.Comment2;
import com.wagdybuild.retrofitproject.models.Post;
import com.wagdybuild.retrofitproject.models.Post2;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostInterface {
    @GET("posts")
    public Call<ArrayList<Post2>> getPosts();

    @GET("comments")
    public Call<ArrayList<Comment2>> getComments(@Query("postId") String postId);
}
