package com.wagdybuild.retrofitproject.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wagdybuild.retrofitproject.R
import com.wagdybuild.retrofitproject.databinding.PostViewBinding
import com.wagdybuild.retrofitproject.models.Post
import com.wagdybuild.retrofitproject.models.Post2
import com.wagdybuild.retrofitproject.ui.CommentsActivity

class PostAdapter(context: Context) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private var itemList: ArrayList<Post2> = ArrayList()
    private var context: Context

    init {
        this.context = context
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(itemList: ArrayList<Post2>){
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_view, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = itemList[position]

        holder.binding.postTitle.text = post.category
        holder.binding.postBody.text = post.content
        holder.binding.postUserId.text = post.publishedAt

        Glide.with(context).load(post.image).into(holder.binding.rivPostImage)
        holder.itemView.setOnClickListener {
            val intent = Intent(context,CommentsActivity::class.java)
            intent.putExtra("postId",post.id.toString())
            context.startActivity(intent)
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: PostViewBinding = PostViewBinding.bind(view)
    }
}