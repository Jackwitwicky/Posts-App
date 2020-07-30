package com.jacknkiarie.postsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacknkiarie.postsapp.R
import com.jacknkiarie.postsapp.models.Post

class PostAdapter(private var posts: List<Post>) : RecyclerView.Adapter<PostHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_post_list, parent, false)

        return PostHolder(v)
    }

    fun updateData(posts: List<Post>) {
        this.posts = posts
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val postItem = posts[position]
        holder.bindGroup(postItem)
    }

}