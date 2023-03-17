package com.example.mvvmrestapi.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmrestapi.R
import com.example.mvvmrestapi.model.Post

class PostListAdapter(private val postList:ArrayList<Post>):RecyclerView.Adapter<PostViewHolder>(){

    fun updatePostList(newUpdatedPosts:List<Post>){
        postList.clear()
        postList.addAll(newUpdatedPosts)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = inflate.inflate(R.layout.posts_items,parent,false)
        return PostViewHolder(view = view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
      holder.idU.text= postList[position].id.toString()
      holder.title.text= postList[position].title
      holder.body.text = postList[position].body

    }
}

class PostViewHolder(val  view:View): RecyclerView.ViewHolder(view){

    val idU:TextView = view.findViewById(R.id.id_user)
    val title:TextView = view.findViewById(R.id.title_post)
    val body:TextView = view.findViewById(R.id.body)
}