 package com.example.retrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapi.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
     //ViewBinding
     private lateinit var binding: ActivityMainBinding
     lateinit var viewModel: MainActivityViewModel
     lateinit var recyclerViewAdapter: RecyclerViewAdapter


     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         // setContentView(R.layout.activity_main)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

         initRecyclerView()
         initViewModel()
         searchUser()
     }

     private fun searchUser() {
         binding.searchBtn.setOnClickListener {
             if(!TextUtils.isEmpty(binding.searchEt.text.toString())){
               viewModel.searchUser(binding.searchEt.text.toString())
             }else{
                 viewModel.getUserList()
             }
         }
     }

     private fun initRecyclerView() {
         binding.recyclerView.apply {
             layoutManager = LinearLayoutManager(this@MainActivity)
             val decoration =
                 DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
             addItemDecoration(decoration)
             recyclerViewAdapter = RecyclerViewAdapter()
             adapter = recyclerViewAdapter

         }
     }

     fun initViewModel() {
         viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
         viewModel.getUserListObservable().observe(this, Observer<UserList> {
             if(it === null){
             Toast.makeText(this@MainActivity, "no result found...", Toast.LENGTH_LONG).show()
                }else{
                 recyclerViewAdapter.userList = it.data.toMutableList()
                 recyclerViewAdapter.notifyDataSetChanged()
                }
              })
              viewModel.getUserList()
          }
 }