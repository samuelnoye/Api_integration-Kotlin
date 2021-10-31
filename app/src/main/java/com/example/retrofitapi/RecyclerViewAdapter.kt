package com.example.retrofitapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {



   var userList = mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_list, parent, false )
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewName  = view.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val textViewStats = view.findViewById<TextView>(R.id.textViewStats)

        fun bind(data : User){
            textViewName.text = data.name
            textViewEmail.text = data.email
            textViewStats.text = data.status
            }
    }

}