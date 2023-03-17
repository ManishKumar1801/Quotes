package com.example.quotes

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quotes.databinding.ListItemBinding


class MyAdapter(val context: Activity,val ArrayList:List<Result>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view=LayoutInflater.from(parent.context)
        val binding:ListItemBinding= DataBindingUtil.inflate(view,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem=ArrayList[position]
        with(holder.binding){
            quotes.text=currentItem.content
            writer.text=currentItem.author
        }
    }

    override fun getItemCount(): Int {
        return ArrayList.size
    }

    class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){

    }










}