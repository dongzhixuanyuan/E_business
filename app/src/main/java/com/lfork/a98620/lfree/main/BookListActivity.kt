package com.lfork.a98620.lfree.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import com.lfork.a98620.lfree.R
import com.lfork.a98620.lfree.data.base.entity.BookCategory
import com.lfork.a98620.lfree.data.base.entity.Books
import com.lfork.a98620.lfree.data.base.entity.Data
import com.lfork.a98620.lfree.data.goods.GoodsDataRepository
import com.lfork.a98620.lfree.main.index.BookGridApater
import com.lfork.a98620.lfree.main.index.BookItemClickListener
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.goods_search_act.*

class BookListActivity : AppCompatActivity() {


    companion object {

        private val KEY_OF_BOOK_CATEGORY = "KEY_OF_BOOK_CATEGORY"
        fun startBookListActivity(context: Context, bean: BookCategory) {
            val intent = Intent(context, BookListActivity::class.java)
            intent.putExtra(KEY_OF_BOOK_CATEGORY, bean)
            context.startActivity(intent)
        }
    }

    private lateinit var bean: BookCategory

    private lateinit var booksAdapter: BookGridApater

    private var books: MutableList<Data> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        bean = intent.getSerializableExtra(KEY_OF_BOOK_CATEGORY) as BookCategory
        supportActionBar?.title = bean.catalog
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        booksAdapter = BookGridApater(books, object : BookItemClickListener {
            override fun onBookItemClick(bean: Data) {
                BookDetailActivity.startDetailBookActivity(this@BookListActivity, bean)
            }
        })
        rv_books.adapter = booksAdapter
        rv_books.layoutManager = GridLayoutManager(this, 2)
        GoodsDataRepository.newGetBooksForCategory(bean.id.toInt()) {
            books.addAll(it.result.data)
            booksAdapter.notifyDataSetChanged()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }
}
