package com.wagdybuild.retrofitproject.data;

import com.wagdybuild.retrofitproject.models.Comment;
import com.wagdybuild.retrofitproject.models.Comment2;
import com.wagdybuild.retrofitproject.models.Post;
import com.wagdybuild.retrofitproject.models.Post2;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClients {
    //private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String BASE_URL = "https://jsonplaceholder.org/";
    private final PostInterface postInterface;
    private static PostClients INSTANCE;

    public PostClients() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface = retrofit.create(PostInterface.class);

    }

    public static PostClients getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new PostClients();
        }
        return INSTANCE;
    }

    public Call<ArrayList<Post2>> getPosts(){
        return postInterface.getPosts();
    }
    public Call<ArrayList<Comment2>> getComments(String postId){
        return postInterface.getComments(postId);
    }
}
