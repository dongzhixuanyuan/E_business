package com.lfork.a98620.lfree.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.lfork.a98620.lfree.R
import com.lfork.a98620.lfree.data.base.entity.Data
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {


    companion object {
        val KEY_OF_BOOK_DATA ="KEY_OF_BOOK_DATA"
        fun startDetailBookActivity(context: Context,bean:Data){
            var intent = Intent(context,BookDetailActivity::class.java)
            intent.putExtra(KEY_OF_BOOK_DATA,bean)
            context.startActivity(intent)
        }
    }

    private lateinit var bean: Data


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        bean = intent.getSerializableExtra(KEY_OF_BOOK_DATA) as Data
        supportActionBar?.title = bean.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        Glide.with(this).load(bean.img).into(cover_img)
        title_tv.text = bean.title
        catalog_tv.text = bean.catalog
        reading_count_tv.text = bean.reading
        by_time.text = bean.bytime
        sub_title_one.text = bean.sub1
        sub_title_two.text = bean.sub2
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }
}
