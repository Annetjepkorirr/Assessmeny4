package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.InvalidationTracker
import com.example.myapplication.R
import com.example.myapplication.ViewModel.PostAdapter
import com.example.myapplication.ViewModel.PostViewModel
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val postViewModel:PostViewModel by viewModels()

    private lateinit var postAdapter: PostAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView: RecyclerView = binding.rvRecycler
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager
        postAdapter = PostAdapter(emptyList())
        recyclerView.adapter = postAdapter


    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()
        postViewModel.postLiveData.observe(this, Observer{ postdisplay ->
            var postAdapter = PostAdapter(postdisplay?: emptyList())
            binding.rvRecycler.layoutManager =LinearLayoutManager(this@MainActivity)
            binding.rvRecycler.adapter=postAdapter

            Toast.makeText(
                baseContext,
                "fetched ${postdisplay?.size} products",
                Toast.LENGTH_LONG
            ).show()

        })
        postViewModel.errorLiveData.observe(this, Observer{ error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()

        })
    }
}