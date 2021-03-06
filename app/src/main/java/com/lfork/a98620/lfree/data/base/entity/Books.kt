package com.lfork.a98620.lfree.data.base.entity

import java.io.Serializable

/**
 * @description 文件描述
 *
 * @author liudong (liudong@rd.netease.com)
 * @date 2020/4/29 6:33 PM
 */
data class Books(
    val error_code: Int,
    val reason: String,
    val result: Result,
    val resultcode: String
):Serializable

data class Result(
    val `data`: List<Data>,
    val pn: Int,
    val rn: String,
    val totalNum: String
):Serializable

data class Data(
    val bytime: String,
    val catalog: String,
    val img: String,
    val online: String,
    val reading: String,
    val sub1: String,
    val sub2: String,
    val tags: String,
    val title: String
):Serializable

data class Categories(
    val error_code: Int,
    val reason: String,
    val result: List<BookCategory>,
    val resultcode: String
):Serializable

data class BookCategory(
    val catalog: String,
    val id: String
):Serializable