package com.example.zerkalorssfeed

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.zerkalorssfeed.api.ApiFactory
import com.example.zerkalorssfeed.database.RSSDatabase
import com.example.zerkalorssfeed.pojos.Item
import com.example.zerkalorssfeed.utils.getDescription
import com.example.zerkalorssfeed.utils.stringDateToStamp
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.collections.ArrayList


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = RSSDatabase.getInstance(application)
    val rssList = db.getDao().getNewsFeed()

    init {
        loadData()
    }

    private fun loadData() {
        ApiFactory.apiService.loadNewsFeed()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                val itemList = it.channel?.itemList as ArrayList<Item>
                itemList.map {
                    it.timeStamp = it.pubDate?.stringDateToStamp()
                    it.description = it.descriptionWithImage?.getDescription()
                }
                db.getDao().insertRssItems(itemList)
            }
    }
}