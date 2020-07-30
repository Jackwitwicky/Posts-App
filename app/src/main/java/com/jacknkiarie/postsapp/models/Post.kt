package com.jacknkiarie.postsapp.models

class Post (val userId: Int, val id: Int, val title: String, val body: String) {
    override fun toString(): String {
        return "User id: $userId, PostId: $id, Title: $title, Body: $body"
    }
}