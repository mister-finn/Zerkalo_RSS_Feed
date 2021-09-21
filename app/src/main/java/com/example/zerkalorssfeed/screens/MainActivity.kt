package com.example.zerkalorssfeed.screens

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zerkalorssfeed.MainViewModel
import com.example.zerkalorssfeed.adapters.RSSAdapter
import com.example.zerkalorssfeed.databinding.ActivityMainBinding
import com.example.zerkalorssfeed.pojos.Item

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(MainViewModel::class.java)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        viewmodel.rssList.observe(this, {
            val adapter = RSSAdapter(it)
            adapter.clickListener = object : RSSAdapter.OnItemClickListener {
                override fun onClick(item: Item) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                    startActivity(intent)
                }
            }
            binding.recyclerView.adapter = adapter
        })


    }
}