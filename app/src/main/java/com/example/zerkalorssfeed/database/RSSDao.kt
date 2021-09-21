package com.example.zerkalorssfeed.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zerkalorssfeed.pojos.Item

@Dao
interface RSSDao {
    @Query("SELECT * FROM rss_item ORDER BY timeStamp DESC ")
    fun getNewsFeed(): LiveData<List<Item>>

    @Query("SELECT * FROM rss_item ORDER BY timeStamp DESC ")
    suspend fun getItemList(): List<Item>

    @Query("SELECT * FROM rss_item WHERE id == :id")
    fun getRssItem(id: Int): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRssItems(itemsList: List<Item>)

}