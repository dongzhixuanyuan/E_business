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

class BookGridApater(val photos: List<Data>, val listener: BookItemClickListener) :
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
        holder.bind(photos[position], listener)
    }
}

class CategoryGridAdapter(
    val categories: List<BookCategory>,
    val listener: CategoryItemClickListener
) :
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
        return categories.size
    }

    override fun onBindViewHolder(holder: PhotoGridViewHolder, position: Int) {
        holder.bindCategory(categories[position], listener)
    }
}

interface BookItemClickListener {
    fun onBookItemClick(bean: Data)
}


interface CategoryItemClickListener {
    fun onCategoryItemClick(bean: BookCategory)
}


class PhotoGridViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {


    fun bind(book: Data, listener: BookItemClickListener) {
        Glide.with(itemView).load(book.img).into(itemView.cover_img)
        itemView.setOnClickListener {
            listener.onBookItemClick(book)
        }

    }

    fun bindCategory(category: BookCategory, listener: CategoryItemClickListener) {
        itemView.category_tv.text = category.catalog
        itemView.setOnClickListener {
            listener.onCategoryItemClick(category)
        }
    }

}