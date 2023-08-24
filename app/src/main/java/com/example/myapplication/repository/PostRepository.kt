package com.example.myapplication.repository

import com.example.myapplication.Api.ApiClient
import com.example.myapplication.Api.ApiInterface
import com.example.myapplication.ViewModel.PostViewModel
import com.example.myapplication.model.PostModel
import com.google.android.gms.common.api.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {
    val apiClient =ApiClient.buildClient(ApiInterface::class.java)

 suspend fun getPosts(): retrofit2.Response<List<PostModel>> {
     return  withContext(Dispatchers.IO){
         apiClient.getPosts()
     }
 }

}