package com.example.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.post
import kotlinx.coroutines.launch

class PostModel :ViewModel(){
    val post = PostModel()
    val postLiveData = MutableLiveData<List<post>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchpost(){
        viewModelScope.launch {
            val response = post.getPost()
            if(response.isSuccessful){
                postLiveData.postValue(response.body()?.post)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}