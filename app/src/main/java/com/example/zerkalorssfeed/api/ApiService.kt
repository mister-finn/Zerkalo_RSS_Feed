package com.example.zerkalorssfeed.api

import com.example.zerkalorssfeed.pojos.NewsFeed
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET("a~1.rss")
    fun loadNewsFeed(): Single<NewsFeed>
}