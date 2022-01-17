package com.example.a3_rvcustomadapter_header_with_footer.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_rvcustomadapter_header_with_footer.R
import com.example.a3_rvcustomadapter_header_with_footer.model.User
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class CustomAdapter(val users: List<User>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ITEM_HEADER = 0
    private val TYPE_ITEM_YES_VIEW = 1
    private val TYPE_ITEM_NOT_VIEW = 2
    private val TYPE_ITEM_FOOTER = 3

    override fun getItemViewType(position: Int): Int {
        if (isHeader(position)) return TYPE_ITEM_HEADER
        if (isFooter(position)) return TYPE_ITEM_FOOTER

        val user = users.get(position)
        return if (user.available) TYPE_ITEM_YES_VIEW else TYPE_ITEM_NOT_VIEW
    }

    fun isHeader(position: Int):Boolean{
        return position ==0;
    }
    fun isFooter(position: Int):Boolean{
        return position ==users.size-1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType==TYPE_ITEM_HEADER){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_header,parent,false)
            return CustomViewHolderHeader(view)
        }
        else if (viewType==TYPE_ITEM_YES_VIEW){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_yes,parent,false)
            return CustomViewHolderYes(view)
        }
        else if (viewType==TYPE_ITEM_NOT_VIEW){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_not,parent,false)
            return CustomViewHolderNot(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_footer,parent,false)
        return CustomViewHolderFooter(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val  user = users.get(position)

        if (holder is CustomViewHolderYes){
            holder.name1.setText(user.first_name)
            holder.name2.setText(user.last_name)
        }

        if (holder is CustomViewHolderNot){
            holder.name1.setText(user.first_name)
            holder.name2.setText(user.last_name)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class CustomViewHolderHeader(itemView:View):RecyclerView.ViewHolder(itemView){

    }
    class CustomViewHolderYes(itemView: View):RecyclerView.ViewHolder(itemView){
        val name1 = itemView.findViewById<TextView>(R.id.first_name)
        val name2 = itemView.findViewById<TextView>(R.id.last_name)
    }
    class CustomViewHolderNot(itemView: View):RecyclerView.ViewHolder(itemView){
        val name1 = itemView.findViewById<TextView>(R.id.first_name)
        val name2 = itemView.findViewById<TextView>(R.id.last_name)
    }
    class CustomViewHolderFooter(itemView: View):RecyclerView.ViewHolder(itemView){

    }






}