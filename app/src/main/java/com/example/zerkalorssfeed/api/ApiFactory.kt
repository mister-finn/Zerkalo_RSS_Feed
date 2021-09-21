package com.example.zerkalorssfeed.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ApiFactory {
    private const val BASE_URL = "https://news.zerkalo.io/rss/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService:ApiService = retrofit.create(ApiService::class.java)
}