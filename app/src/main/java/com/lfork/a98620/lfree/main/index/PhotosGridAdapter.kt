package com.lfork.a98620.lfree.main.index

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lfork.a98620.lfree.R
import com.lfork.a98620.lfree.data.base.entity.BookCategory
import com.lfork.a98620.lfree.data.base.entity.Books
import com.lfork.a98620.lfree.data.base.entity.Data
import kotlinx.android.synthetic.main.category_grid_item.view.*

class CategoryGridAdapter(val photos: List<Data>, val listener: ItemClickListener) :
    RecyclerView.Adapter<PhotoGridViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridViewHolder {
        return PhotoGridViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.category_grid_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoGridViewHolder, position: Int) {
        holder.bind(photos[position],position,listener)
    }
}

interface ItemClickListener {
    fun onItemClick(bean:Data)
}

class PhotoGridViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {


    fun bind(photo: Data, position: Int, listener: ItemClickListener) {
        Glide.with(itemView).load(photo.img).into(itemView.cover_img)
        itemView.setOnClickListener {
            listener.onItemClick(photo)
        }

    }


}