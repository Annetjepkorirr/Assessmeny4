package com.example.myapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.PostModel
import com.example.myapplication.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel(){
    val post = PostRepository()
    val postLiveData = MutableLiveData<List<PostModel>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchPosts(){
        viewModelScope.launch{
            val response=post.getPosts()
            if(response.isSuccessful){
                val postsList = response.body() ?: emptyList()
                postLiveData.postValue(postsList as
                        List<PostModel>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}