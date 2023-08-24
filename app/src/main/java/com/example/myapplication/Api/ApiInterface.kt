package com.example.myapplication.Api

import com.example.myapplication.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<PostModel>>
}