package com.wagdybuild.retrofitproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wagdybuild.retrofitproject.adapters.CommentAdapter
import com.wagdybuild.retrofitproject.databinding.ActivityCommentsBinding
import com.wagdybuild.retrofitproject.ui.main.PostViewModel

class CommentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentsBinding
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postId = intent.getStringExtra("postId")
        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]

        val adapter = CommentAdapter(this)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = adapter

        postViewModel.getComments(postId)
        postViewModel.getCommentLiveData().observe(this) {
            adapter.setItemList(it)
        }

    }
}