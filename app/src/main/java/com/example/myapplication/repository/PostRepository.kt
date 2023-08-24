package com.example.myapplication.repository

import com.example.myapplication.viewmodels.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {
    private lateinit var repository: PostRepository
    private val API_URL = "https://jsonplaceholder.typicode.com/posts"
    private val API_BASE_URL = "https://jsonplaceholder.typicode.com"
    private var posts: MutableList<PostModel> = mutableListOf()

}