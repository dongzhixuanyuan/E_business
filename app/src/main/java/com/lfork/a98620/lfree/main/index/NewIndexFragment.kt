package com.lfork.a98620.lfree.main.index

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lfork.a98620.lfree.R
import com.lfork.a98620.lfree.data.base.entity.BookCategory
import com.lfork.a98620.lfree.data.base.entity.Books
import com.lfork.a98620.lfree.data.base.entity.Category
import com.lfork.a98620.lfree.data.base.entity.Data
import com.lfork.a98620.lfree.data.goods.GoodsDataRepository
import com.lfork.a98620.lfree.main.BookDetailActivity
import com.lfork.a98620.lfree.main.BookListActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.new_index_fragment.*

/**
 * @description 文件描述
 *
 * @author liudong (liudong@rd.netease.com)
 * @date 2020/4/29 8:41 PM
 */


class NewIndexFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_index_fragment,container,false)
    }

    private var categoryAdapter:CategoryGridAdapter? = null
    private var allBoks:MutableList<Data> = arrayListOf()
    private var categories:MutableList<BookCategory> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        categoryAdapter = CategoryGridAdapter(categories, object : CategoryItemClickListener {
            override fun onCategoryItemClick(bean: BookCategory) {
                    BookListActivity.startBookListActivity(context!!,bean)
            }
        })
        categories_rv.adapter = categoryAdapter
        categories_rv.layoutManager = GridLayoutManager(context,2)

        GoodsDataRepository.newGetBookCategory {
            categories.addAll(it.result)
            categoryAdapter?.notifyDataSetChanged()
        }


    }

}