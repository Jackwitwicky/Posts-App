package com.jacknkiarie.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacknkiarie.postsapp.R
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var postAdapter : PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        // setup recyclerview
        postAdapter = PostAdapter(listOf())
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        posts_recyclerview.layoutManager = layoutManager
        posts_recyclerview.adapter = postAdapter

        // setup view model
        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        posts_progress_bar.visibility = View.VISIBLE
        postViewModel.getPosts()
        postViewModel.postsResponse.observe(this, Observer { posts ->
            posts_progress_bar.visibility = View.GONE
            postAdapter.updateData(posts)
            postAdapter.notifyDataSetChanged()
        })
    }
}
