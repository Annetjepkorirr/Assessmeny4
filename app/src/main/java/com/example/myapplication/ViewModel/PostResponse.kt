package com.example.myapplication.ViewModel

import com.example.myapplication.model.PostModel

data class PostResponse(
    var post:List<PostModel>,
    var userId: Int,
    var id:Int,
    var title: String,
    var body: String,

)
