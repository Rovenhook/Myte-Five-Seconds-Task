package com.rovenhook.mytefivesecondstask

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.rovenhook.mytefivesecondstask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NumberListenter {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter: NumberAdapter = NumberAdapter(this)
        binding.recyclerViewNumbers.adapter = adapter

        val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            4
        } else {
            2
        }
        binding.recyclerViewNumbers.layoutManager = GridLayoutManager(this, spanCount)

        viewModel = ViewModelProvider(this).get(NumberViewModel::class.java)
        viewModel.getNumbersList().observe(this, Observer {
            adapter.submitList(it.toList())
        })
    }

    override fun delete(valuetoDelete: String) {
        viewModel.deleteNumber(valuetoDelete)
    }
}