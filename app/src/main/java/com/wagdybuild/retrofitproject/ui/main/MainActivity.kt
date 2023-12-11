package com.wagdybuild.retrofitproject.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wagdybuild.retrofitproject.adapters.PostAdapter
import com.wagdybuild.retrofitproject.databinding.ActivityMainBinding
import com.wagdybuild.retrofitproject.models.Post2

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        val adapter = PostAdapter(this)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = adapter

        postViewModel.getPosts()
        postViewModel.getPostsLiveData().observe(this) {
            adapter.setItemList(it as ArrayList<Post2>)
        }

    }
}