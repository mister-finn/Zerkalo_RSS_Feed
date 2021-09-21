package com.example.zerkalorssfeed.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.zerkalorssfeed.pojos.Item
import com.example.zerkalorssfeed.utils.AuthorNameConverter

@Database(entities = [Item::class], version = 1, exportSchema = false)
@TypeConverters(AuthorNameConverter::class)
abstract class RSSDatabase : RoomDatabase() {
    companion object {
        private var db: RSSDatabase? = null
        private const val DB_NAME = "rss.db"
        private val LOCK = Any()

        fun getInstance(context: Context): RSSDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, RSSDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration().build()
                db = instance
                return instance
            }
        }

    }

    abstract fun getDao(): RSSDao
}