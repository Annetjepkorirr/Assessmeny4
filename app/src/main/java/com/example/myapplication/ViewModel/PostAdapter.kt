package com.example.myapplication.ViewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.PostdisplayBinding
import com.example.myapplication.model.PostModel

class PostAdapter(var postdisplay:List<PostModel>):RecyclerView.Adapter<PostAdapter.PostHolder>(){
    lateinit var binding: PostdisplayBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder{
        val binding =PostdisplayBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)

    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val currentPost =postdisplay[position]
        val binding= holder.binding
        binding.tvid.text=currentPost.id.toString()
        binding.tvtitle.text=currentPost.title
        binding.tvbody.text=currentPost.body
    }

    override fun getItemCount(): Int {
        return postdisplay.size

    }

    class PostHolder(var binding: PostdisplayBinding):RecyclerView.ViewHolder(binding.root){

    }

}