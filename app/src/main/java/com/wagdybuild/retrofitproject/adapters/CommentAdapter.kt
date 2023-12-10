package com.wagdybuild.retrofitproject.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wagdybuild.retrofitproject.R
import com.wagdybuild.retrofitproject.databinding.CommentViewBinding
import com.wagdybuild.retrofitproject.databinding.PostViewBinding
import com.wagdybuild.retrofitproject.models.Comment
import com.wagdybuild.retrofitproject.models.Comment2
import com.wagdybuild.retrofitproject.models.Post
import com.wagdybuild.retrofitproject.ui.CommentsActivity

class CommentAdapter(context: Context) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    private var itemList: ArrayList<Comment2> = ArrayList()
    private var context: Context

    init {
        this.context = context
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(itemList: ArrayList<Comment2>){
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comment_view, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = itemList[position]

        holder.binding.commentEmail.text = comment.userId.toString()
        holder.binding.commentBody.text = comment.comment
        holder.binding.commentId.text = comment.postId.toString()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: CommentViewBinding = CommentViewBinding.bind(view)
    }
}