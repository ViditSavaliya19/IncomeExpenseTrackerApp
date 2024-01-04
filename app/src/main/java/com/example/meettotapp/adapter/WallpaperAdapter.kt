package com.example.meettotapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.meettotapp.R
import com.example.meettotapp.newsapi.NewsActivity
import com.example.meettotapp.newsapi.model.HitsItem

class WallpaperAdapter(val newsActivity: NewsActivity,val hits: List<HitsItem?>?) : RecyclerView.Adapter<WallpaperAdapter.ViewDataHolder>() {

    class  ViewDataHolder(itemView: View) : ViewHolder(itemView)
    {
        var imgWallItem =itemView.findViewById<ImageView>(R.id.imgWallItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewDataHolder {
        var view =LayoutInflater.from(newsActivity).inflate(R.layout.wall_item,parent,false)
        return  ViewDataHolder(view)
    }

    override fun getItemCount(): Int {
        return  hits!!.size
    }

    override fun onBindViewHolder(holder: ViewDataHolder, position: Int) {
        Glide.with(newsActivity).load(hits!![position]!!.webformatURL).placeholder(R.drawable.ic_launcher_background).into(holder.imgWallItem)
    }

}