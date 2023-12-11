package com.wagdybuild.retrofitproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wagdybuild.retrofitproject.data.PostClients
import com.wagdybuild.retrofitproject.models.Comment2
import com.wagdybuild.retrofitproject.models.Post2
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    private var postLiveData = MutableLiveData<List<Post2>>()
    private var commentLiveData = MutableLiveData<List<Comment2>>()
    private val postClients:PostClients = PostClients()
    fun getPostsLiveData(): MutableLiveData<List<Post2>> = postLiveData
    fun getCommentsLiveData() : MutableLiveData<List<Comment2>> = commentLiveData
    fun getPosts(){
         viewModelScope.launch{
             postLiveData.value =postClients.getPosts()
         }
    }
    fun getComments(postId: String) {
        viewModelScope.launch{
            commentLiveData.value = postClients.getComments(postId)
        }

    }


}
/*package com.wagdybuild.retrofitproject.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wagdybuild.retrofitproject.data.PostClients;
import com.wagdybuild.retrofitproject.models.Comment;
import com.wagdybuild.retrofitproject.models.Comment2;
import com.wagdybuild.retrofitproject.models.Post;
import com.wagdybuild.retrofitproject.models.Post2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Post2>> postLiveData = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Comment2>> commentLiveData = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Post2>> getPostLiveData(){
        return postLiveData;
    }
    public MutableLiveData<ArrayList<Comment2>> getCommentLiveData(){
        return commentLiveData;
    }
    public void getPosts(){
        PostClients.getINSTANCE().getPosts().enqueue(new Callback<ArrayList<Post2>>() {
            @Override
            public void onResponse(Call<ArrayList<Post2>> call, Response<ArrayList<Post2>> response) {
                postLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post2>> call, Throwable t) {

            }
        });
    }
    public void getComments(String postId){
        PostClients.getINSTANCE().getComments(postId).enqueue(new Callback<ArrayList<Comment2>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment2>> call, Response<ArrayList<Comment2>> response) {
                commentLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Comment2>> call, Throwable t) {

            }
        });
    }
}
*/