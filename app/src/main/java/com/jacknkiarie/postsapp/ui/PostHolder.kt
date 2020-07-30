package com.jacknkiarie.postsapp.ui

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jacknkiarie.postsapp.models.Post
import kotlinx.android.synthetic.main.item_post_list.view.*

class PostHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

    private var view: View  = v
    private var post: Post? = null

    init {
        v.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("Recyclerview", "CLICK!")
    }

    fun bindGroup(post: Post) {
        this.post = post

        view.item_post_title.text = post.title
        view.item_post_body.text = post.body
    }

}